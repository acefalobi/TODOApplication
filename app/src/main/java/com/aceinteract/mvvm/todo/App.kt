package com.aceinteract.mvvm.todo

import android.app.Application
import com.aceinteract.mvvm.todo.data.repository.TaskRepository
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : Application() {

    private val appModule = module {
        single { TaskRepository(get()) }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App.applicationContext)
            modules(appModule)
        }
    }

}