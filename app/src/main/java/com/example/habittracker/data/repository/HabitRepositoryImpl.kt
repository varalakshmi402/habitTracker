package com.example.habittracker.data.repository

import com.example.habittracker.data.local.dao.HabitDao
import com.example.habittracker.data.local.entity.Habit
import com.example.habittracker.domain.repository.HabitRepository
import kotlinx.coroutines.flow.Flow

class HabitRepositoryImpl(private val dao: HabitDao):HabitRepository {
    override fun getHabits(): Flow<List<Habit>> =dao.getHabits()

    override suspend fun insertHabit(habit: Habit)=dao.insertHabit(habit)
    override suspend fun deleteHabit(habit: Habit)=dao.deleteHabit(habit)
}