package com.example.habittracker.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.habittracker.data.local.dao.HabitDao
import com.example.habittracker.data.local.entity.Habit

@Database(
    entities = [Habit::class],
    version = 1,
    exportSchema = false
)
abstract class HabitDatabase : RoomDatabase() {
    abstract fun habitDao():HabitDao
}