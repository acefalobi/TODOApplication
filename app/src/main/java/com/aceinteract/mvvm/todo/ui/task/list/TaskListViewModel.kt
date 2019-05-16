package com.aceinteract.mvvm.todo.ui.task.list

import android.app.Application
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import com.aceinteract.mvvm.todo.data.KamikazeLiveData
import com.aceinteract.mvvm.todo.data.entity.Task
import com.aceinteract.mvvm.todo.ui.base.BaseViewModel

class TaskListViewModel(application: Application) : BaseViewModel(application) {

    val tasks: KamikazeLiveData<List<Task>> = taskRepository.getTasks()

    val taskList = ObservableArrayList<Task>()

    val tasksEmpty = ObservableBoolean(false)

    fun markAsCompleted(task: Task) = taskRepository.updateTask(task.apply { completed = true })

    fun deleteTask(task: Task) = taskRepository.deleteTask(task)

}
