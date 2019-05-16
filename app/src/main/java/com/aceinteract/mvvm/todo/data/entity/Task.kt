package com.aceinteract.mvvm.todo.data.entity

import androidx.room.Entity
import java.util.*

@Entity(tableName = "tasks")
data class Task (

    val title: String,
    val description: String = "",
    var completed: Boolean = false,

    val dueDate: Calendar

) : BaseEntity() {

    val isPastDueDate
        get() = dueDate.after(Calendar.getInstance())

}