package com.example.prakharandroidintern.ui.trending

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prakharandroidintern.adapters.TrendingAdapter
import com.example.prakharandroidintern.databinding.FragmentTrendingBinding
import com.example.prakharandroidintern.viewmodels.TrendingViewModel

class TrendingFragment : Fragment() {

    private val trendingViewModel: TrendingViewModel by viewModels()
    private var _binding: FragmentTrendingBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTrendingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Trending"

        val adapter = TrendingAdapter(trendingViewModel.trendingTags.value!!)
        val recyclerView = binding.rvTrending
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}