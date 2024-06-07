package com.example.todolist.presentation.fragments.homeScreen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.core.constants.CONSTANTS
import com.example.todolist.core.listeners.ClickListener
import com.example.todolist.databinding.TasksItemBinding
import com.example.todolist.domain.entity.Tasks

class TasksAdapter(
    private val onTaskClickListener: ClickListener? = null,
) : RecyclerView.Adapter<TasksAdapter.ViewHolder>() {

    private val diffUtil = object : DiffUtil.ItemCallback<Tasks>() {
        override fun areItemsTheSame(oldItem: Tasks, newItem: Tasks): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Tasks, newItem: Tasks): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, diffUtil)

    class ViewHolder(val binding: TasksItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            TasksItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = differ.currentList[position]
        holder.binding.apply {
            titleText.text = data.title
            descriptionText.text = data.description

            checkbox.isChecked = data.isCompleted?: false

            deleteButton.setOnClickListener {
                onTaskClickListener?.onItemClick(id = data.id, type = CONSTANTS.DELETE)
            }

            checkbox.setOnClickListener {
                onTaskClickListener?.onItemClick(id = data.id, isChecked = checkbox.isChecked, type = CONSTANTS.UPDATE)
            }
        }
    }
}