package com.example.todoapp.data

import androidx.room.Database
import com.example.todoapp.data.models.ToDoTask


@Database(entities = [ToDoTask::class], version = 1, exportSchema = false)
abstract class ToDoDatabase {
}