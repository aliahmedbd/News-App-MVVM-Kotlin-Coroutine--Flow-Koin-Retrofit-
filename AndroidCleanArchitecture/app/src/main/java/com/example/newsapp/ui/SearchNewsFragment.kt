package com.example.newsapp.ui

import Article
import android.content.Context
import android.os.Bundle
import android.telephony.TelephonyManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.adapter.NewsListAdapter
import com.example.newsapp.databinding.FragmentSearchNewsBinding
import com.example.newsapp.network.ResponseModel
import com.example.newsapp.viewmodel.NewsViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.util.*


class SearchNewsFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentSearchNewsBinding
    private val newsViewModel: NewsViewModel by sharedViewModel()
    private lateinit var newsListAdapter: NewsListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_search_news, null, false)
        clickListeners()
        getLatestHeadlines()
        receiveLatestHeadline()
        return binding.root
    }

    private fun clickListeners() {
        binding.btnSearch.setOnClickListener {
            if (binding.textInputLayout.editText?.text.toString().isNotEmpty()) {
                lifecycleScope.launch {
                    newsViewModel.transmitKeyword(binding.textInputLayout.editText?.text.toString())
                    val bottomNavigationView =
                        activity?.findViewById(R.id.bottom_navigation) as BottomNavigationView
                    bottomNavigationView.selectedItemId = R.id.newsFragment
                }
            } else {
                Toast.makeText(context, "Please enter valid keyword.", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun getLatestHeadlines() {
        newsViewModel.viewModelScope.launch {
            val tm = context?.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            val countryCodeValue = tm.networkCountryIso
            val timeZone = Calendar.getInstance().timeZone.getDisplayName(false, TimeZone.SHORT)
            timeZone?.let { newsViewModel.getLatestHeadline(countryCodeValue) }
        }
    }

    private fun receiveLatestHeadline() {
        binding.rvLatestNews.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                newsViewModel.latestHeadlineUpdate.collectLatest { it ->
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
                                            resource = R.layout.item_latest_headlines,
                                            onItemClick = {
                                                redirectToDetails(it)
                                            },
                                            onFavItemClick = {
                                                context?.let { ctx ->
                                                    newsViewModel.saveArticle(
                                                        it,
                                                        ctx
                                                    )
                                                }
                                            }
                                        )
                                    binding.rvLatestNews.adapter = newsListAdapter
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private fun redirectToDetails(articles: Article) {
        newsViewModel.viewModelScope.launch {
            articles.link.let { it?.let { it1 -> newsViewModel.transmitNewsURL(it1) } }
        }
        val bottomNavigationView =
            activity?.findViewById(R.id.bottom_navigation) as BottomNavigationView
        bottomNavigationView.selectedItemId = R.id.detailNewsFragment
    }

    private fun showDialog() {
        newsViewModel.viewModelScope.launch {
            withContext(Dispatchers.Main) {
                Toast.makeText(context, "Loading...", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun dismissDialog() {
        newsViewModel.viewModelScope.launch {
            withContext(Dispatchers.Main) {

            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchNewsFragment().apply {}
    }
}