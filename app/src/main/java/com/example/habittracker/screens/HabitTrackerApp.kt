package com.example.habittracker.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun HabitTrackerApp() {
    val navController: NavHostController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "splash"
    ){
        composable("splash"){
            SplashScreen(navController)
        }
        composable("home") {
            HomeScreen(navController)
        }
        composable("habitListScreen") {
            HabitListScreen(navController)
        }
        composable("addHabitScreen"){
            AddHabitScreen(navController)
        }
    }
}