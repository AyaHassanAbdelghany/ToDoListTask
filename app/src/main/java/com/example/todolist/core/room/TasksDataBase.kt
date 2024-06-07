package com.example.todolist.core.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.todolist.data.source.local.TasksDao
import com.example.todolist.domain.entity.Tasks

@Database(entities = [Tasks::class], version = 2, exportSchema = false)
@TypeConverters(TasksTypeConverter::class)
abstract class TasksDataBase: RoomDatabase() {
    abstract fun tasksDao(): TasksDao
}