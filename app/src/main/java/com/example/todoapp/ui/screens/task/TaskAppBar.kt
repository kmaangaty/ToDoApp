package com.example.todoapp.ui.screens.task

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.example.todoapp.R
import com.example.todoapp.data.models.Priority
import com.example.todoapp.data.models.ToDoTask
import com.example.todoapp.ui.theme.topAppBarBackgroundColor
import com.example.todoapp.ui.theme.topAppBarContentColor
import com.example.todoapp.util.Action

@Composable
fun TaskAppBar(
    navigateToListScreen: (Action) -> Unit
){
    NewTaskAppBar(navigateToListScreen = navigateToListScreen)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewTaskAppBar(
    navigateToListScreen: (Action) -> Unit
){
    TopAppBar(
        navigationIcon = {
            BackAction (onBackClicked = navigateToListScreen)
        },
        title = {
            Text(
                text = "Add Task",
                color = MaterialTheme.topAppBarContentColor
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.topAppBarBackgroundColor,
            titleContentColor = MaterialTheme.topAppBarContentColor
        ),
        actions = {
            AddAction (onAddClicked = navigateToListScreen)
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExistingAppBar(
    selectedTask: ToDoTask,
    navigateToListScreen: (Action) -> Unit
){
    TopAppBar(
        navigationIcon = {
            CloseAction(onCloseClicked = navigateToListScreen)
        },
        title = {
            Text(
                text = selectedTask.title,
                color = MaterialTheme.topAppBarContentColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.topAppBarBackgroundColor,
            titleContentColor = MaterialTheme.topAppBarContentColor
        ),
        actions = {
            DeleteAction(onDeleteClicked = navigateToListScreen)
            UpdateAction(onUpdateClicked = navigateToListScreen)
        }
    )
}


@Composable
fun BackAction(
    onBackClicked: (Action) -> Unit
) {
    IconButton(
        onClick = { onBackClicked(Action.NO_ACTION) }
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = stringResource(R.string.back_icon),
            tint = MaterialTheme.topAppBarContentColor
        )
    }
}

@Composable
fun CloseAction(
    onCloseClicked: (Action) -> Unit
) {
    IconButton(
        onClick = { onCloseClicked(Action.NO_ACTION) }
    ) {
        Icon(
            imageVector = Icons.Filled.Close,
            contentDescription = stringResource(R.string.close_description),
            tint = MaterialTheme.topAppBarContentColor
        )
    }
}


@Composable
fun DeleteAction(
    onDeleteClicked: (Action) -> Unit
) {
    IconButton(
        onClick = { onDeleteClicked(Action.NO_ACTION) }
    ) {
        Icon(
            imageVector = Icons.Filled.Delete,
            contentDescription = stringResource(R.string.delete_description),
            tint = MaterialTheme.topAppBarContentColor
        )
    }
}


@Composable
fun UpdateAction(
    onUpdateClicked: (Action) -> Unit
) {
    IconButton(
        onClick = { onUpdateClicked(Action.NO_ACTION) }
    ) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = stringResource(R.string.update_description),
            tint = MaterialTheme.topAppBarContentColor
        )
    }
}


@Composable
fun AddAction(
    onAddClicked: (Action) -> Unit
) {
    IconButton(
        onClick = { onAddClicked(Action.ADD) }
    ) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = stringResource(R.string.add_task),
            tint = MaterialTheme.topAppBarContentColor
        )
    }
}


@Composable
@PreviewLightDark
fun PreviewAppBar(){
    NewTaskAppBar(navigateToListScreen = {})
}


@Composable
@PreviewLightDark
fun PreviewNewAppBar(){
    ExistingAppBar(
        selectedTask = ToDoTask(
            id = 0,
            title = "Hello World",
            description = "Ranom Text",
            priority = Priority.LOW
        ),
        navigateToListScreen = {}
    )
}




