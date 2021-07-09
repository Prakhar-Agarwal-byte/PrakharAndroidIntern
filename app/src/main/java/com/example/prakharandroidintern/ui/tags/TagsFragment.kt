package com.example.prakharandroidintern.ui.tags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.prakharandroidintern.MainActivity
import com.example.prakharandroidintern.R
import com.example.prakharandroidintern.databinding.FragmentTagsBinding
import com.example.prakharandroidintern.ui.tags.TagsViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class TagsFragment : Fragment() {

    private lateinit var tagsViewModel: TagsViewModel
    private var _binding: FragmentTagsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tagsViewModel =
            ViewModelProvider(this).get(TagsViewModel::class.java)

        _binding = FragmentTagsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().findViewById<BottomNavigationView>(R.id.nav_view).visibility = View.VISIBLE
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Tags"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}