package com.example.todolist.domain.repo

import com.example.todolist.domain.entity.Tasks

interface TasksRepo {
    suspend fun getAllTasks(): List<Tasks>
    suspend fun deleteTaskById(id: Long): Int
    suspend fun addTask(task: Tasks): Long
    suspend fun updateTask(id: Long,isCompleted: Boolean): Int
    suspend fun deleteAllTasks(): Int
}