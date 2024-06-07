package com.example.todolist.di

import com.example.todolist.domain.repo.TasksRepo
import com.example.todolist.domain.useCase.AddTaskUseCase
import com.example.todolist.domain.useCase.DeleteAllTasksUseCase
import com.example.todolist.domain.useCase.DeleteTaskByIdUseCase
import com.example.todolist.domain.useCase.GetAllTasksUseCase
import com.example.todolist.domain.useCase.TasksUseCase
import com.example.todolist.domain.useCase.UpdateTaskByIdUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object TasksUseCaseModule {

    @Provides
    fun provideAddTaskUseCase(tasksRepo: TasksRepo): AddTaskUseCase {
        return AddTaskUseCase(tasksRepo)
    }
    @Provides
    fun provideDeleteAllTasksUseCase(tasksRepo: TasksRepo): DeleteAllTasksUseCase {
        return DeleteAllTasksUseCase(tasksRepo)
    }

    @Provides
    fun provideDeleteTaskByIdUseCase(tasksRepo: TasksRepo): DeleteTaskByIdUseCase {
        return DeleteTaskByIdUseCase(tasksRepo)
    }

    @Provides
    fun provideGetAllTasksUseCase(tasksRepo: TasksRepo): GetAllTasksUseCase {
        return GetAllTasksUseCase(tasksRepo)
    }

    @Provides
    fun provideUpdateTaskByIdUseCase(tasksRepo: TasksRepo): UpdateTaskByIdUseCase {
        return UpdateTaskByIdUseCase(tasksRepo)
    }

    @Provides
    fun provideTasksUseCase(
        getAllTasksUseCase: GetAllTasksUseCase,
        updateTaskByIdUseCase: UpdateTaskByIdUseCase,
        deleteTaskByIdUseCase: DeleteTaskByIdUseCase,
        deleteAllTasksUseCase: DeleteAllTasksUseCase
    ): TasksUseCase {
        return TasksUseCase(
            getAllTasksUseCase = getAllTasksUseCase,
            updateTaskByIdUseCase = updateTaskByIdUseCase,
            deleteTaskByIdUseCase = deleteTaskByIdUseCase,
            deleteAllTasksUseCase = deleteAllTasksUseCase
        )
    }
}