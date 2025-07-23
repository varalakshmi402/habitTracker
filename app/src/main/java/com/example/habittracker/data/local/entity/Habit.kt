package com.example.habittracker.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "habit_table")
data class Habit(
    @PrimaryKey(autoGenerate = true)
    val id :Int = 0,
    val title: String,
    val timeStamp:Long = System.currentTimeMillis())
