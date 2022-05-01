package com.example.androidcleanarchitecture.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.androidcleanarchitecture.R
import com.example.androidcleanarchitecture.databinding.FragmentFilterBinding


class FilterFragment : Fragment() {

    private lateinit var binding: FragmentFilterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_filter, null, false)
        return binding.root
    }
}