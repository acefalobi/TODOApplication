package com.aceinteract.mvvm.todo.ui.task.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aceinteract.mvvm.todo.data.entity.Task
import com.aceinteract.mvvm.todo.databinding.TaskCardItemBinding


class TaskCardListAdapter(private val actionListener: TaskActionListener)
    : ListAdapter<Task, TaskCardListAdapter.ViewHolder>(TaskListAdapter.TaskDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(TaskCardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = getItem(position)
        holder.apply {
            bind(actionListener, task)
            itemView.tag = task
        }
    }

    class ViewHolder(
        private val binding: TaskCardItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(actionListener: TaskActionListener, item: Task) {
            binding.apply {
                listener = actionListener
                task = item
                executePendingBindings()
            }
        }
    }
}