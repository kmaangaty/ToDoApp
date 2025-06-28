package com.example.todoapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.todoapp.data.models.ToDoTask
import com.example.todoapp.util.Constants.TODO_TABLE
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {

    @Query("Select * From $TODO_TABLE ORDER BY id ASC")
    fun getAllTasks(): Flow<List<ToDoTask>>

    @Query("SELECT * FROM $TODO_TABLE WHERE id=:taskID")
    fun getSelectedTask(taskID: Int): Flow<ToDoTask>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(toDoTask: ToDoTask)
    
    @Update
    suspend fun updateTask(toDoTask: ToDoTask)

    @Delete
    suspend fun deleteTask(toDoTask: ToDoTask)
}