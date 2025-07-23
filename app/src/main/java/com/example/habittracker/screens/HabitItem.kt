package com.example.habittracker.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.habittracker.data.local.entity.Habit

@Composable
fun HabitItem(habit : Habit, onDeleteClick:(Habit)->Unit) {
    Card(modifier= Modifier.fillMaxWidth()
        .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ){
            Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Column (modifier = Modifier.padding(16.dp)){
                    Text(text = habit.title, style= MaterialTheme.typography.titleMedium)
                    Text(text = "Created : ${java.text.SimpleDateFormat("MMM dd,yyyy").format(habit.timeStamp)}")
                }
                IconButton (onClick = {onDeleteClick(habit)}){
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete Habit",
                        tint = Color.Red
                    )
                }
            }
    }
}