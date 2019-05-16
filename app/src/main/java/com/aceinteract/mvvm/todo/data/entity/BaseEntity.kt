package com.aceinteract.mvvm.todo.data.entity

import androidx.room.PrimaryKey
import java.util.*

abstract class BaseEntity {

    @PrimaryKey
    val id: String = UUID.randomUUID().toString()

}