package com.example.newsapp.ui

import com.example.newsapp.model.Article
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.adapter.NewsListAdapter
import com.example.newsapp.databinding.FragmentNewsBinding
import com.example.newsapp.network.ResponseModel
import com.example.newsapp.viewmodel.NewsViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.util.ArrayList

class NewsFragment : Fragment() {

    private lateinit var binding: FragmentNewsBinding
    private val viewModel: NewsViewModel by sharedViewModel()
    private lateinit var newsListAdapter: NewsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_news, null, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvNews.layoutManager = LinearLayoutManager(requireContext())
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiUpdates.collectLatest { it ->
                    when (it) {
                        is ResponseModel.Error -> {
                            Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                        }
                        is ResponseModel.Idle -> {
                            Toast.makeText(requireContext(), "Idle State", Toast.LENGTH_SHORT)
                                .show()
                        }
                        is ResponseModel.Loading -> {
                            showDialog()
                        }
                        is ResponseModel.Success -> {
                            dismissDialog()
                            if (it.data?.body()?.articles.isNullOrEmpty()) {
                                Toast.makeText(
                                    requireContext(),
                                    "No data found.",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                it.data?.body()?.articles?.let { articles ->
                                    newsListAdapter =
                                        NewsListAdapter(
                                            articleList = articles as ArrayList<Article>,
                                            resource = R.layout.item_news,
                                            onItemClick = {
                                                redirectToDetails(it)
                                            },
                                            onFavItemClick = {
                                                context?.let { context ->
                                                    viewModel.saveArticle(
                                                        it,
                                                        context
                                                    )
                                                }
                                            })
                                    binding.rvNews.adapter = newsListAdapter
                                }
                            }
                        }
                    }
                }
            }
        }

        viewModel.viewModelScope.launch {
            viewModel.category.collectLatest { category ->
                viewModel.keyword.collectLatest { keyword ->
                    if (keyword.isNotEmpty())
                        viewModel.getNews(category, keyword)
                    else
                        viewModel.getNews(category, "all")
                }
            }
        }
    }

    private fun redirectToDetails(articles: Article) {
        viewModel.viewModelScope.launch {
            articles.link.let { it?.let { it1 -> viewModel.transmitNewsURL(it1) } }
        }
        val bottomNavigationView =
            activity?.findViewById(R.id.bottom_navigation) as BottomNavigationView
        bottomNavigationView.selectedItemId = R.id.detailNewsFragment
    }

    private fun showDialog() {
        viewModel.viewModelScope.launch {
            withContext(Dispatchers.Main) {
                Toast.makeText(context, "Loading...", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun dismissDialog() {
        viewModel.viewModelScope.launch {
            withContext(Dispatchers.Main) {

            }
        }
    }

}