package com.example.todolist.core.room

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.todolist.domain.entity.Tasks
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@TypeConverters
class TasksTypeConverter {

    @TypeConverter
    fun fromProductMerchantsItemList(productMerchantsItemList: List<Tasks>): String {
        return Gson().toJson(productMerchantsItemList)
    }

    @TypeConverter
    fun toProductMerchantsItemList(json: String): List<Tasks> {
        val type = object : TypeToken<List<Tasks>>() {}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun fromProduct(tasks: Tasks): String {
        return Gson().toJson(tasks)
    }

    @TypeConverter
    fun toProduct(json: String): Tasks {
        val type = object : TypeToken<Tasks>() {}.type
        return Gson().fromJson(json, type)
    }

}