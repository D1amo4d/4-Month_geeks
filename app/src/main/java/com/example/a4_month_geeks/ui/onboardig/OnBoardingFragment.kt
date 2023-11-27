package com.example.a4_month_geeks.ui.onboardig

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.a4_month_geeks.R
import com.example.a4_month_geeks.data.local.Pref
import com.example.a4_month_geeks.databinding.FragmentOnBoardingBinding
import com.example.a4_month_geeks.ui.onboardig.adapter.OnBoardingAdapter
import com.google.android.material.tabs.TabLayoutMediator

class OnBoardingFragment : Fragment() {
    lateinit var binding: FragmentOnBoardingBinding
    private val adapter = OnBoardingAdapter(this::onClic)

    private val pref:Pref by lazy {
        Pref(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = adapter
        binding.apply {

            viewPager.adapter = adapter//ViewPager2
            TabLayoutMediator(tabLayout, viewPager) { _, _ -> }.attach()//ViewPager
        }

    }

    private fun onClic() {
        pref.onBoardingShpw()
        findNavController().navigate(R.id.navigation_home)
    }
}