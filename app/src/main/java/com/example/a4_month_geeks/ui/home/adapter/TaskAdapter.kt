package com.example.a4_month_geeks.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.a4_month_geeks.databinding.ItemTaskBinding
import com.example.a4_month_geeks.model.Task


class TaskAdapter() : Adapter<TaskAdapter.TaskViewHolder>() {
    private val list = arrayListOf<Task>(//динамичный лист...


    )

    fun addNewTask(task: Task) {//перерисовка листа при добавлении нового листа..
        list.add(0, task)
        /* notifyDataSetChanged() все удоляет и заново перерисовывает */
        notifyItemChanged(0)//добавление лишь новых данных
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        return holder.bind(list[position])
    }

    inner class TaskViewHolder(private val binding: ItemTaskBinding) : ViewHolder(binding.root) {
        fun bind(task: Task) {
            binding.tvTitle.text = task.title
            binding.tvDesk.text = task.desk

        }

    }
}
