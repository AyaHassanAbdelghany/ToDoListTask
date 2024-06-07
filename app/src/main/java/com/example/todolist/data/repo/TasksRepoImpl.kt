package com.example.todolist.data.repo

import com.example.todolist.data.source.local.TasksDao
import com.example.todolist.domain.entity.Tasks
import com.example.todolist.domain.repo.TasksRepo
import javax.inject.Inject

class TasksRepoImpl @Inject constructor(
    private val tasksDao: TasksDao,
): TasksRepo {
    override suspend fun getAllTasks(): List<Tasks> {
        return tasksDao.getAllTasks()
    }

    override suspend fun deleteTaskById(id: Long): Int {
        return tasksDao.deleteTaskById(id = id)
    }

    override suspend fun addTask(task: Tasks): Long {
        return tasksDao.upsertTask(task = task)
    }

    override suspend fun updateTask(id: Long, isCompleted: Boolean): Int {
        return tasksDao.updateTaskById(id = id, isCompleted = isCompleted)
    }

    override suspend fun deleteAllTasks(): Int {
       return tasksDao.deleteAllTasks()
    }
}