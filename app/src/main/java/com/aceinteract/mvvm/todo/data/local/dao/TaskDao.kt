package com.aceinteract.mvvm.todo.data.local.dao

import androidx.room.*
import com.aceinteract.mvvm.todo.data.KamikazeLiveData
import com.aceinteract.mvvm.todo.data.entity.Task

@Dao
interface TaskDao {

    @Query("SELECT * FROM tasks")
    fun getTasks(): KamikazeLiveData<List<Task>>

    @Query("SELECT * FROM tasks WHERE id = :taskId")
    fun getTask(taskId: String): KamikazeLiveData<Task>

    @Update
    fun updateTask(task: Task)

    @Insert
    fun insertTask(task: Task): Long

    @Delete
    fun deleteTask(task: Task)

}