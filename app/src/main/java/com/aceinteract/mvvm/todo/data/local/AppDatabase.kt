package com.aceinteract.mvvm.todo.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.aceinteract.mvvm.todo.data.entity.Task
import com.aceinteract.mvvm.todo.data.local.AppDatabase.AppDataBaseHelper.DATABASE_NAME
import com.aceinteract.mvvm.todo.data.local.dao.TaskDao
import com.aceinteract.mvvm.todo.util.DateConverter

@Database(entities = [Task::class], version = AppDatabase.AppDataBaseHelper.DATABASE_VERSION, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    companion object {

        private var INSTANCE: AppDatabase? = null

        private val lock = Any()

        /**
         * Creates of gets single instance of Room Database
         */
        fun getInstance(context: Context): AppDatabase {
            synchronized(lock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        AppDatabase::class.java, DATABASE_NAME
                    ).build()
                }
                return INSTANCE!!
            }
        }
    }

    object AppDataBaseHelper {

        const val DATABASE_VERSION = 1

        const val DATABASE_NAME = "TODO.db"

    }

}