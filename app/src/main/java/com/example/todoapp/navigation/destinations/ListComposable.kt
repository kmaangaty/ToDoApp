package com.example.todoapp.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.todoapp.util.Constants.LIST_ACTION
import com.example.todoapp.util.Constants.LIST_ARGUMENT_KEY

fun NavGraphBuilder.listComposable(
    navigateToTaskScreen : (Int) -> Unit
){
    composable(
        route = LIST_ACTION,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY){
            type = NavType.StringType
        })
    ){

    }

}