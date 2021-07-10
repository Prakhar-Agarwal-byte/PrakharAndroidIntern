package com.example.prakharandroidintern.ui.explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prakharandroidintern.R
import com.example.prakharandroidintern.adapters.ExploreClickListener
import com.example.prakharandroidintern.adapters.ExploreAdapter
import com.example.prakharandroidintern.databinding.FragmentExploreBinding
import com.example.prakharandroidintern.viewmodels.MainActivityViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class ExploreFragment : Fragment(), ExploreClickListener {

    private var _binding: FragmentExploreBinding? = null
    private val exploreViewModel: MainActivityViewModel by activityViewModels()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentExploreBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ExploreAdapter(requireActivity(), exploreViewModel.exploreList.value!!,this)
        val recyclerView = binding.rvExplore
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }

        })
    }

    override fun onItemClick(position: Int) {
        exploreViewModel.addToSavedList(exploreViewModel.exploreList.value!![position])
    }

    override fun onStart() {
        super.onStart()
        val toolbar = requireActivity().findViewById<Toolbar>(R.id.custom_toolbar)
        toolbar.visibility = View.VISIBLE
        toolbar.title = "Explore #tags"
        toolbar.subtitle = "Golf Course Road, Delhi"
        requireActivity().findViewById<BottomNavigationView>(R.id.nav_view)?.visibility = View.VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}