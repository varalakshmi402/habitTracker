package com.example.habittracker.Container

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.habittracker.data.local.entity.Habit
import com.example.habittracker.screens.AddHabitScreen
import com.example.habittracker.screens.HabitViewModel
import kotlinx.coroutines.launch

@Composable
fun AddHabitContainer(
    viewModel: HabitViewModel = hiltViewModel(),
    onNavigateToHabitListScreen:()->Unit
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    var habitName  by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    AddHabitScreen(habitName = habitName,
        onHabitNameChange = { habitName = it },
        onAddHabit = { viewModel.insertHabits(Habit(title = habitName))
                                focusManager.clearFocus()
                                keyboardController?.hide()
                                coroutineScope.launch { snackbarHostState.showSnackbar("Habit Added Succesfully", duration = SnackbarDuration.Short) }},
        onViewHabit = onNavigateToHabitListScreen)
}