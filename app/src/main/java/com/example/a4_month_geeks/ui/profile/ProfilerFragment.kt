package com.example.a4_month_geeks.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.a4_month_geeks.databinding.FragmentProfilerBinding

class ProfilerFragment : Fragment() {
    private lateinit var binding: FragmentProfilerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentProfilerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            val imgUrl =
                "https://static.vecteezy.com/system/resources/thumbnails/019/900/322/small/happy-young-cute-illustration-face-profile-png.png"
            Glide.with(requireContext()).load(imgUrl).into(profileImage)
            btnSet.setOnClickListener {
                val etUserName = etPrintUsername.text.toString()
                if (etUserName == null) {
                    Toast.makeText(requireContext(), "EditText пустой", Toast.LENGTH_SHORT).show()
                } else {
                    tvUsername.text = etUserName
                }
            }
        }
    }
}