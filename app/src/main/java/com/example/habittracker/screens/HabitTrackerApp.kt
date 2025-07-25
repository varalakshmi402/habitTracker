package com.example.habittracker.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.habittracker.Container.AddHabitContainer
import com.example.habittracker.Container.HabitListScreenContainer

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
        composable("habitListContainer") {
            HabitListScreenContainer (onNavigateToAddhabit = {navController.navigate("addHabitScreen")})
        }
        composable("addHabitScreen"){
            AddHabitContainer (onNavigateToHabitListScreen = { navController.navigate("habitListContainer") })
        }
    }
}