package com.example.todolist.domain.useCase

import com.example.todolist.domain.repo.TasksRepo

class DeleteAllTasksUseCase(private val tasksRepo: TasksRepo) {
    suspend operator fun invoke() = tasksRepo.deleteAllTasks()
}