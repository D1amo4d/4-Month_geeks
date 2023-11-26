package com.example.a4_month_geeks.ui.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.a4_month_geeks.R
import com.example.a4_month_geeks.databinding.FragmentTaskBinding
import com.example.a4_month_geeks.model.Task

class TaskFragment : Fragment() {
    private lateinit var binding: FragmentTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSave.setOnClickListener {


            val titleText = binding.etTitle.text.toString()
            val descText = binding.etDesk.text.toString()

            if (titleText.isNotEmpty() || descText.isNotEmpty()) {
                val data = Task(
                    title = titleText,
                    desk = descText
                )
                setFragmentResult(TASK_RESULT_KEY, bundleOf(TASK_KEY to data)) // передача данных, можно получить с любого места
                findNavController().navigateUp() // переход обратно

            } else {
                val errorMsg = getString(R.string.falseIsNotEmpty)
                val toast = Toast.makeText(requireContext(), errorMsg, Toast.LENGTH_SHORT)
                toast.show()

            }

        }

    }

    companion object {
        const val TASK_RESULT_KEY = "task_result_key"
        const val TASK_KEY = "task_key"
    }
}