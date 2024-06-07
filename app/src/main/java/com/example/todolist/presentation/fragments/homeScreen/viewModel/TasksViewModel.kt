package com.example.todolist.presentation.fragments.homeScreen.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.domain.entity.Tasks
import com.example.todolist.domain.useCase.TasksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TasksViewModel @Inject constructor(
    private val tasksUseCase: TasksUseCase
) : ViewModel() {

    private val _getProductsFromRoom = MutableStateFlow<List<Tasks>>(emptyList())
    val getProductsFromRoom = _getProductsFromRoom.asStateFlow()

     fun getTasks() {
        viewModelScope.launch(Dispatchers.IO) {
            _getProductsFromRoom.value = tasksUseCase.getAllTasksUseCase()
        }
    }


     fun updateTask(id: Long,isCompleted: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            tasksUseCase.updateTaskByIdUseCase(id = id, isCompleted = isCompleted)
        }
    }

    fun deleteTaskById(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            tasksUseCase.deleteTaskByIdUseCase(id = id)
            getTasks()
        }
    }

    fun deleteAllTasks() {
        viewModelScope.launch(Dispatchers.IO) {
            tasksUseCase.deleteAllTasksUseCase()
            getTasks()
        }
    }

}