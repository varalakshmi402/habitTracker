package com.example.habittracker.domain.repository

import com.example.habittracker.data.local.entity.Habit
import kotlinx.coroutines.flow.Flow

interface HabitRepository {
     fun getHabits(): Flow<List<Habit>>
    suspend fun insertHabit(habit:Habit)

}