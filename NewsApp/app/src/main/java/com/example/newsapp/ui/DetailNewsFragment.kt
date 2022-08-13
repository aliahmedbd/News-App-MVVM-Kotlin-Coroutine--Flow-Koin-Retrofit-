package com.example.newsapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentDetailNewsBinding
import com.example.newsapp.viewmodel.NewsViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class DetailNewsFragment : Fragment() {

    private lateinit var binding: FragmentDetailNewsBinding
    private val viewModel: NewsViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_detail_news, null, false)
        lifecycleScope.launch {
            viewModel.newsURL.collect {
                loadURL(it)
            }
        }
        return binding.root
    }

    private fun loadURL(url: String) {
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.webViewClient = WebViewClient()
        binding.webView.loadUrl(url)
    }
}

