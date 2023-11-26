package com.example.a4_month_geeks.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.a4_month_geeks.R
import com.example.a4_month_geeks.databinding.FragmentHomeBinding
import com.example.a4_month_geeks.model.Task
import com.example.a4_month_geeks.ui.home.adapter.TaskAdapter
import com.example.a4_month_geeks.ui.task.TaskFragment.Companion.TASK_KEY
import com.example.a4_month_geeks.ui.task.TaskFragment.Companion.TASK_RESULT_KEY

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val adapter = TaskAdapter()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvAnime.adapter = adapter



            binding.btnFab.setOnClickListener {
                setFragmentResultListener(TASK_RESULT_KEY) { _, bundle ->//получение данных
                    val data = bundle.getSerializable(TASK_KEY) as Task//насильно зостволяем быть Таском
                    adapter.addNewTask(data)

            }
                findNavController().navigate(R.id.taskFragment)
        }
    }


}