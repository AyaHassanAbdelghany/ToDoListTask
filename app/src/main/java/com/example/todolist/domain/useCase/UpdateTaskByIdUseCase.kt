package com.example.todolist.domain.useCase

import com.example.todolist.domain.repo.TasksRepo

class UpdateTaskByIdUseCase(private val tasksRepo: TasksRepo) {
    suspend operator fun invoke(id: Long,isCompleted: Boolean) = tasksRepo.updateTask(id = id, isCompleted = isCompleted)
}