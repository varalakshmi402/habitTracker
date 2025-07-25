package com.example.habittracker.Container

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.habittracker.screens.HabitListScreen
import com.example.habittracker.screens.HabitViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

@Composable
fun HabitListScreenContainer(
    viewModel: HabitViewModel=hiltViewModel(),
    onNavigateToAddhabit:()->Unit
) {
    val habits by viewModel.habits.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    HabitListScreen(
        habits = habits,
        snackbarHostState = snackbarHostState,onDeleteHabit = {habit -> viewModel.deleteHabit(habit)
    coroutineScope.launch {
            val result = snackbarHostState.showSnackbar("Habit Deleted Succesfully",
                actionLabel = "UNDO",
                duration = SnackbarDuration.Short)
        if(result==SnackbarResult.ActionPerformed){
            viewModel.insertHabits(habit)
        }
    }},
        onAddHabitClick = onNavigateToAddhabit)
}