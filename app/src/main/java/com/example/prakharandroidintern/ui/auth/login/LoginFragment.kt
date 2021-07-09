package com.example.prakharandroidintern.ui.auth.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.prakharandroidintern.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.btnSendOTP.setOnClickListener {
            val mobileNumber = binding.etMobileNumber.editableText.toString()
            val action = LoginFragmentDirections.actionLoginFragmentToOTPFragment(mobileNumber)
            this.findNavController().navigate(action)
        }

        return binding.root
    }

}