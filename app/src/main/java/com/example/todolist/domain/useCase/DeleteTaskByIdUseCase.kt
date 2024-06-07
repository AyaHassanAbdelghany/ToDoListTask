package com.example.todolist.domain.useCase

import com.example.todolist.domain.repo.TasksRepo

class DeleteTaskByIdUseCase(private val tasksRepo: TasksRepo) {
    suspend operator fun invoke(id: Long) = tasksRepo.deleteTaskById(id = id)
}