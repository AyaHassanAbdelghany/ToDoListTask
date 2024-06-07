package com.example.todolist.domain.useCase

import com.example.todolist.domain.repo.TasksRepo

class GetAllTasksUseCase(private val tasksRepo: TasksRepo) {
    suspend operator fun invoke() = tasksRepo.getAllTasks()
}