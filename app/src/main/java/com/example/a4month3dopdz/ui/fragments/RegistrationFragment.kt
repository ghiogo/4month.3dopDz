package com.example.a4month3dopdz.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.a4month3dopdz.R
import com.example.a4month3dopdz.databinding.FragmentRegistrationBinding
import com.example.a4month3dopdz.utils.PreferenceHelper

class RegistrationFragment : Fragment() {

    private lateinit var binding: FragmentRegistrationBinding
    private val preferenceHelper: PreferenceHelper = PreferenceHelper()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
    }

    private fun initialize() {
        preferenceHelper.unit(requireContext())
    }

    private fun setupListener() = with(binding) {
        binding.btnButton.setOnClickListener {

            if (edGmail.text!!.isNotEmpty() || edPassword.text!!.isNotEmpty()) {
                preferenceHelper.saveText = edGmail.text.toString().trim()
                preferenceHelper.savePass = edPassword.text.toString().trim()
            }
            if (edGmail.text!!.isEmpty() || edPassword.text!!.isEmpty()) {
                if (edPassword.text!!.isEmpty()) {
                    edPassword.error = "Заполните поля"
                }
                if (edGmail.text!!.isEmpty()) {
                    edGmail.error = "Заполните поля"
                }
            }
            if (edGmail.length() in 0..4 || edPassword.length() in 0..7) {
                if (edGmail.length() in 1..4) {
                    edGmail.error = "Логин должен быть больше 5 символов"
                }
                if (edPassword.length() in 1..7) {
                    edPassword.error = "Пароль должен быть больше 8 символов"
                }
            } else {
                findNavController().navigate(R.id.action_registrationFragment_to_registrationDetailFragment)
            }
        }
    }
}