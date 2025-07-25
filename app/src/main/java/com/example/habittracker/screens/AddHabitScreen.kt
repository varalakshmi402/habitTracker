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
fun AddHabitScreen(
    habitName:String,
    onHabitNameChange:(String)->Unit,
    onAddHabit:()->Unit,
                   onViewHabit:()->Unit) {

    Scaffold (
    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp)
        ) {
            Text(text = "Name your Habit", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.padding(12.dp))
            Spacer(modifier = Modifier.padding(12.dp))
            Row(modifier = Modifier.fillMaxSize()) {
                Button(onClick = {
                    onAddHabit()
                }) { Text("Add") }
                Button(onClick = {
                    onViewHabit()
                }) { Text("View Habit List") }
            }
        }
    }
    }