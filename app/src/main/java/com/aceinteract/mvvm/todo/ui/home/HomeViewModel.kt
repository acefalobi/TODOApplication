package com.aceinteract.mvvm.todo.ui.home

import android.app.Application
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import com.aceinteract.mvvm.todo.data.entity.Task
import com.aceinteract.mvvm.todo.ui.base.BaseViewModel

class HomeViewModel(application: Application) : BaseViewModel(application) {

    val upcomingTasks = ObservableArrayList<Task>()

    val tasks: LiveData<List<Task>> = taskRepository.getTasks()

    val taskList = ObservableArrayList<Task>()

    val tasksEmpty = ObservableBoolean(false)

    fun markAsCompleted(task: Task) = taskRepository.updateTask(task.apply { completed = true })

    fun deleteTask(task: Task) = taskRepository.deleteTask(task)

}
