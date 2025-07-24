package com.example.habittracker.screens

import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(
    onLoginClick:(String,String)->Unit,
    onGoogleSignInclick:()->Unit,
    onNavigateToSignUp:()->Unit
) {
    var email by remember {mutableStateOf("")}
    var password by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ){
        Text(text= "Login to HabitTracker", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(24.dp))
        TextField(
            value = email,
            onValueChange = {email = it},
            label={ Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = password,
            onValueChange = {password=it},
            label = { Text("Password")},
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer (modifier = Modifier.height(24.dp))
        Button(onClick = {onLoginClick(email,password)},
    modifier = Modifier.fillMaxWidth()) {Text("Login") }
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedButton(
            onClick = {onGoogleSignInclick()},
            modifier = Modifier.fillMaxWidth()){
                Text("Continue with Google")
            }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Text("Don't have an account?")
            TextButton( onClick = onNavigateToSignUp) { Text("Sign Up")}
        }
    }
}