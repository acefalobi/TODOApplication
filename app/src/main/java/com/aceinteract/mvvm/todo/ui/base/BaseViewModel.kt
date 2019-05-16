package com.aceinteract.mvvm.todo.ui.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.aceinteract.mvvm.todo.data.repository.TaskRepository
import org.koin.android.ext.android.inject

abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {

    protected val taskRepository: TaskRepository by application.inject()

}