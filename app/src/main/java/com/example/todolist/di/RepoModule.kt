package com.example.todolist.di


import com.example.todolist.data.repo.TasksRepoImpl
import com.example.todolist.data.source.local.TasksDao
import com.example.todolist.domain.repo.TasksRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    fun provideTasksRepo(
        tasksDao: TasksDao,
    ): TasksRepo {
        return TasksRepoImpl(
            tasksDao
        )
    }

}