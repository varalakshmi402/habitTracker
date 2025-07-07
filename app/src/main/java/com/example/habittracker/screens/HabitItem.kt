package com.example.habittracker.screens

import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.habittracker.data.local.entity.Habit

@Composable
fun HabitItem(habit : Habit) {
    Card(modifier= Modifier.fillMaxWidth()
        .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ){
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = habit.title, style= MaterialTheme.typography.titleMedium)
            Text(text = " Created : ${java.text.SimpleDateFormat("MMM dd,yyyy").format(habit.timeStamp)}")
        }
    }
}