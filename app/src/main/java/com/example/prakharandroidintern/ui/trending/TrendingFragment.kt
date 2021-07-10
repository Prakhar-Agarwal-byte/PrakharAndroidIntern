package com.example.prakharandroidintern.ui.trending

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prakharandroidintern.R
import com.example.prakharandroidintern.adapters.TrendingAdapter
import com.example.prakharandroidintern.databinding.FragmentTrendingBinding
import com.example.prakharandroidintern.viewmodels.TrendingViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView


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
        val layoutManager = LinearLayoutManager(activity)
        val recyclerView = binding.rvTrending
        val dividerItemDecoration = DividerItemDecoration(
            recyclerView.context,
            layoutManager.orientation
        )
        recyclerView.addItemDecoration(dividerItemDecoration)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        val toolbar = requireActivity().findViewById<Toolbar>(R.id.custom_toolbar)
        toolbar.visibility = View.VISIBLE
        toolbar.title = "Trending Now"
        toolbar.subtitle = "Golf Course Road, Delhi"
        requireActivity().findViewById<BottomNavigationView>(R.id.nav_view)?.visibility = View.VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}