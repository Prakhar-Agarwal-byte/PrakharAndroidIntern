package com.example.prakharandroidintern.ui.saved

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prakharandroidintern.R
import com.example.prakharandroidintern.adapters.ExploreClickListener
import com.example.prakharandroidintern.adapters.ExploreAdapter
import com.example.prakharandroidintern.adapters.SavedAdapter
import com.example.prakharandroidintern.adapters.SavedClickListener
import com.example.prakharandroidintern.databinding.FragmentExploreBinding
import com.example.prakharandroidintern.databinding.FragmentSavedBinding
import com.example.prakharandroidintern.viewmodels.MainActivityViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class SavedFragment : Fragment(), SavedClickListener {

    private var _binding: FragmentSavedBinding? = null
    private val savedViewModel: MainActivityViewModel by activityViewModels()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSavedBinding.inflate(inflater, container, false)
        return return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = SavedAdapter(requireActivity(), savedViewModel.savedList.value!!,this)
        val recyclerView = binding.rvSaved
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
        savedViewModel.savedList.observe(viewLifecycleOwner, Observer {
            adapter.updateList(it)
        })
    }

    override fun onItemClick(position: Int) {
        savedViewModel.removeFromSavedList(position)
    }

    override fun onStart() {
        super.onStart()
        val toolbar = requireActivity().findViewById<Toolbar>(R.id.custom_toolbar)
        toolbar.visibility = View.VISIBLE
        toolbar.title = "Saved #tags"
        toolbar.subtitle = "Golf Course Road, Delhi"
        requireActivity().findViewById<BottomNavigationView>(R.id.nav_view)?.visibility = View.VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}