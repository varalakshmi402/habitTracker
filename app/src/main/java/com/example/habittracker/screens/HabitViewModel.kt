package com.example.habittracker.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.habittracker.data.local.entity.Habit
import com.example.habittracker.domain.repository.HabitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HabitViewModel @Inject constructor(private val repository: HabitRepository) : ViewModel(){

private val _habits = MutableStateFlow<List<Habit>>(emptyList())
    val habits : MutableStateFlow<List<Habit>> = _habits
    init {
        viewModelScope.launch {
            repository.getHabits().collect{
                habitList->
                _habits.value=habitList
            }
        }

    }
    fun insertHabits(habit:Habit){
        viewModelScope.launch {
            repository.insertHabit(habit)
        }
    }
    fun deleteHabit(habit: Habit){
        viewModelScope.launch {
            repository.deleteHabit(habit)
        }
    }
}