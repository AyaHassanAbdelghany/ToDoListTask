package com.example.todolist.domain.useCase
data class TasksUseCase(
    val getAllTasksUseCase: GetAllTasksUseCase,
    val deleteTaskByIdUseCase: DeleteTaskByIdUseCase,
    val deleteAllTasksUseCase: DeleteAllTasksUseCase,
    val updateTaskByIdUseCase: UpdateTaskByIdUseCase
)