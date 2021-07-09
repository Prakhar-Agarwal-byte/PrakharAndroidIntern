package com.example.prakharandroidintern.ui.tags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getDrawable
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.prakharandroidintern.R
import com.example.prakharandroidintern.databinding.FragmentTagsBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.chip.Chip

class TagsFragment : Fragment() {

    private var _binding: FragmentTagsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTagsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Tags"
         activity?.findViewById<BottomNavigationView>(R.id.nav_view)?.visibility = View.VISIBLE

        binding.btnAddTag.setOnClickListener {
            val searchTerm = binding.etSearchTag.editableText.toString()
            val chip = Chip(requireActivity())
            chip.apply {
                text = searchTerm
                closeIcon = getDrawable(requireActivity(), R.drawable.ic_baseline_close_24)
                isCloseIconVisible = true
                setOnCloseIconClickListener {
                    binding.chipGroup.removeView(it)
                }
            }
            binding.chipGroup.addView(chip)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}