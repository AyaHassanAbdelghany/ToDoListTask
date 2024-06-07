package com.example.todolist.core.listeners
interface ClickListener {
    fun onItemClick(id: Long, isChecked: Boolean?= false,type: Int)
}