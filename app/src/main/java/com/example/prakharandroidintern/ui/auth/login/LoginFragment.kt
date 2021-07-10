package com.example.prakharandroidintern.ui.auth.login

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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSendOTP.setOnClickListener {
            onOTPBtnClicked()
        }
    }

    fun onOTPBtnClicked() {
        val mobileNumber = binding.etMobileNumber.editableText.toString()
        if (!mobileNumber.isNullOrBlank()) {
            val action = LoginFragmentDirections.actionLoginFragmentToOTPFragment(mobileNumber)
            this.findNavController().navigate(action)
        }
    }

}