package com.aceinteract.mvvm.todo.ui.task.list

import com.aceinteract.mvvm.todo.data.entity.Task

interface TaskActionListener {

    fun onTaskClicked(task: Task)

    fun onTaskDeleted(task: Task)

    fun onTaskCompleted(task: Task)

}