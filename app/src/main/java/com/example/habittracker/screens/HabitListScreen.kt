package com.example.habittracker.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.habittracker.data.local.entity.Habit
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HabitListScreen(navController: NavController , viewModel: HabitViewModel = hiltViewModel()) {
    val habitList by viewModel.habits.collectAsState()
    var habitToDelete by remember { mutableStateOf<Habit?>(null) }
    var recentlyDeletedHabit by remember { mutableStateOf<Habit?>(null) }
    val coRoutineScope = rememberCoroutineScope ()
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(topBar = {
        TopAppBar(
            title={ Text("Your Habits") },
        )
    },
        snackbarHost = {
            SnackbarHost(hostState=snackbarHostState)
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("addHabitScreen")
            }) { Text("+") }
        }){
        innerPadding->
        LazyColumn (
            contentPadding = innerPadding,
            modifier = Modifier.
            fillMaxSize()
                .padding(16.dp, vertical = 8.dp)
        ){
            items(habitList){
                habit-> HabitItem(habit, onDeleteClick = {habitToDelete=it})
            }
        }
        habitToDelete?.let {habit->
            CustomDialog("Delete Habit?",
                "Are you sure you want to delete the \"${habit.title}\"?",
                "Cancel",
                "Confirm",
                {habitToDelete=null},
                {habitToDelete=null
                        recentlyDeletedHabit=habit
                coRoutineScope.launch { viewModel.deleteHabit(habit) }})
        }
        recentlyDeletedHabit?.let {habit->
            coRoutineScope.launch {
                val result= snackbarHostState.showSnackbar("${habit.title} is deleted","UNDO", duration = SnackbarDuration.Short)
                if(result==SnackbarResult.ActionPerformed){
                    viewModel.insertHabits(habit)
                }
                recentlyDeletedHabit=null
            }
        }

    }

}
