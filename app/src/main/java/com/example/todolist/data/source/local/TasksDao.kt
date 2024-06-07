package com.example.todolist.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.todolist.domain.entity.Tasks
@Dao
interface TasksDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertTask(task: Tasks): Long
    @Query("SELECT * FROM tasks")
    fun getAllTasks(): List<Tasks>
    @Query("DELETE FROM tasks WHERE id = :id")
    suspend fun deleteTaskById(id: Long): Int
    @Query("UPDATE tasks SET isCompleted = :isCompleted WHERE id = :id")
    suspend fun updateTaskById(id: Long,isCompleted: Boolean): Int
    @Query("DELETE FROM tasks")
    suspend fun deleteAllTasks(): Int
}