package com.example.a4month3dopdz.ui.fragments.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.a4month3dopdz.databinding.FragmentRegistrationDetailBinding
import com.example.a4month3dopdz.utils.PreferenceHelper

class RegistrationDetailFragment : Fragment() {

    private lateinit var binding: FragmentRegistrationDetailBinding
    private val preferenceHelper: PreferenceHelper = PreferenceHelper()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        getData()
    }

    private fun initialize() {
        preferenceHelper.unit(requireContext())
    }

    private fun getData() = with(binding) {
        tvName.text = preferenceHelper.saveText
        tvPass.text = preferenceHelper.savePass
    }
}
