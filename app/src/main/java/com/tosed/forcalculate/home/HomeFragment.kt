package com.tosed.forcalculate.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.tosed.forcalculate.R
import com.tosed.forcalculate.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater, R.layout.fragment_home, container, false)

        binding.btnStart.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_perguntaFragment)
        )

        return binding.root
    }
}