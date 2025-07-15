package com.example.habittracker.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HabitListScreen(navController: NavController , viewModel: HabitViewModel = hiltViewModel()) {
    val habitList by viewModel.habits.collectAsState()
    Scaffold(topBar = {
        TopAppBar(
            title={ Text("Your Habits") },
        )
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
                .padding(16.dp)
        ){
            items(habitList){
                habit-> HabitItem(habit)
            }
        }

    }

}
