package com.example.todolist.presentation.fragments.addTaskBottomSheet.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.domain.entity.Tasks
import com.example.todolist.domain.useCase.AddTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddTaskViewModel @Inject constructor(
    private val addTaskUseCase: AddTaskUseCase
) : ViewModel() {
     fun insertProducts(task: Tasks) {
        viewModelScope.launch(Dispatchers.IO) {
            addTaskUseCase.invoke(task)
        }
    }
}