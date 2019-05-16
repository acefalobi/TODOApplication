package com.aceinteract.mvvm.todo.adapters

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aceinteract.mvvm.todo.data.entity.Task
import com.aceinteract.mvvm.todo.ui.task.list.TaskCardListAdapter
import com.aceinteract.mvvm.todo.ui.task.list.TaskListAdapter

@BindingAdapter("app:items")
fun RecyclerView.setItems(items: ArrayList<Task>?) {
    if (items != null) {
        with(adapter as TaskListAdapter) {
            submitList(items)
        }
    }
}

@BindingAdapter("app:cardItems")
fun RecyclerView.setCardItems(items: ArrayList<Task>?) {
    if (items != null) {
        with(adapter as TaskCardListAdapter) {
            submitList(items)
        }
    }
}