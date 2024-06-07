package com.example.todolist.di

import android.app.Application
import androidx.room.Room
import com.example.todolist.core.room.TasksDataBase
import com.example.todolist.data.source.local.TasksDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideTasksDataBase(application: Application): TasksDataBase =
        Room.databaseBuilder(application, TasksDataBase::class.java, "tasks.database")
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun provideTasksDao(tasksDataBase: TasksDataBase): TasksDao {
        return tasksDataBase.tasksDao()
    }

}