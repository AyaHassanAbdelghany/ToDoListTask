package com.example.todolist.domain.useCase

import com.example.todolist.domain.entity.Tasks
import com.example.todolist.domain.repo.TasksRepo

class AddTaskUseCase(private val tasksRepo: TasksRepo) {
    suspend operator fun invoke(task: Tasks) = tasksRepo.addTask(task = task)
}