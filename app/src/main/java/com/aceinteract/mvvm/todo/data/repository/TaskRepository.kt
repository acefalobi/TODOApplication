package com.aceinteract.mvvm.todo.data.repository

import android.content.Context
import com.aceinteract.mvvm.todo.data.entity.Task
import com.aceinteract.mvvm.todo.data.local.AppDatabase

class TaskRepository(context: Context) {

    private val appDatabase = AppDatabase.getInstance(context)

    private val taskDao = appDatabase.taskDao()

    fun getTasks() = taskDao.getTasks()

    fun getTask(taskId: String) = taskDao.getTask(taskId)

    fun updateTask(task: Task) = taskDao.updateTask(task)

    fun insertTask(task: Task) = taskDao.insertTask(task)

    fun deleteTask(task: Task) = taskDao.deleteTask(task)

}