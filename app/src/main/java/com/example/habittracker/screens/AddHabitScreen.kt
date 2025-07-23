package com.example.habittracker.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.habittracker.data.local.entity.Habit
import kotlinx.coroutines.launch

@Composable
fun AddHabitScreen(navController: NavController,viewModel:HabitViewModel = hiltViewModel()) {
    var habitName  by remember { mutableStateOf("") }
    val snackBarHostState  = remember { SnackbarHostState()}
    val scope = rememberCoroutineScope()

    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current


    Scaffold (
        snackbarHost = {SnackbarHost(hostState = snackBarHostState)}) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp)
        ) {
            Text(text = "Name your Habit", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.padding(12.dp))
            TextField(value = habitName, onValueChange = { habitName = it })
            Spacer(modifier = Modifier.padding(12.dp))
            Row(modifier = Modifier.fillMaxSize()) {
                Button(onClick = {
                    viewModel.insertHabits(Habit(title=habitName))
                    keyboardController?.hide()
                    focusManager.clearFocus()

                    scope.launch { snackBarHostState.showSnackbar("Habit Added Succesfully") }
                    habitName = ""
                }) { Text("Add") }
                Button(onClick = {
                    navController.popBackStack()
                }) { Text("View Habit List") }
            }
        }
    }
    }