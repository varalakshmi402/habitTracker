package com.example.habittracker.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.habittracker.data.local.entity.Habit
import com.example.habittracker.domain.repository.HabitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
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
}