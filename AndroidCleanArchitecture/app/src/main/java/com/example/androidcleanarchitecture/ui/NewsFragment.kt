package com.example.androidcleanarchitecture.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidcleanarchitecture.R
import com.example.androidcleanarchitecture.adapter.NewsListAdapter
import com.example.androidcleanarchitecture.databinding.FragmentNewsBinding
import com.example.androidcleanarchitecture.network.ResponseModel
import com.example.androidcleanarchitecture.viewmodel.NewsViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

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
                                    newsListAdapter = NewsListAdapter(articles)
                                    binding.rvNews.adapter = newsListAdapter
                                }
                            }
                        }
                    }
                }
            }
        }

        viewModel.viewModelScope.launch {
            viewModel.category.collectLatest {
                viewModel.getNews(it)
            }
        }
    }

    private fun showDialog() {
        viewModel.viewModelScope.launch {
            withContext(Dispatchers.Main) {

            }
        }
    }

    fun dismissDialog() {
        viewModel.viewModelScope.launch {
            withContext(Dispatchers.Main) {

            }
        }
    }

}