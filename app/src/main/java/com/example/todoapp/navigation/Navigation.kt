package com.example.todoapp.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.todoapp.navigation.destinations.listComposable
import com.example.todoapp.navigation.destinations.taskComposable
import com.example.todoapp.ui.viewmodels.SharedViewModel
import com.example.todoapp.util.Constants.LIST_SCREEN

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetupNavigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    val screen = remember(navController) {
        Screens(navController = navController)
    }
    NavHost(
        navController = navController,
        startDestination = LIST_SCREEN
    ) {
        listComposable(
            navigateToTaskScreen = screen.task,
            sharedViewModel = sharedViewModel
        )
        taskComposable(
            navigateToListScreen = screen.list
        )
    }
}