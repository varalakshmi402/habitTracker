package com.example.habittracker.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.habittracker.data.local.entity.Habit

@Composable
fun DeleteHabitDialog(
    habit:Habit,
    onDismiss:()->Unit,
    onConfirm:()->Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Surface(shape = MaterialTheme.shapes.medium,
            tonalElevation = 6.dp,
            color = MaterialTheme.colorScheme.surface
        ) {
            Column(modifier = Modifier.padding(24.dp)) {
                Text(
                    text="Delete Habit?",
                    style=MaterialTheme.typography.headlineSmall)
                Text(
                    text="Are you sure you want to delete the \"${habit.title}\"?",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(8.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .padding(top=24.dp),
                    horizontalArrangement = Arrangement.End
                ){
                    TextButton(onClick = onDismiss) {
                        Text(text="Cancel")
                    }
                    TextButton(onClick = onConfirm) {
                        Text(text="Delete")
                    }
                }
            }
        }
    }
}