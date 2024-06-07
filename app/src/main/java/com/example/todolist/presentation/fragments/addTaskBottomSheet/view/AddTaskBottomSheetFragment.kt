package com.example.todolist.presentation.fragments.addTaskBottomSheet.view

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.todolist.core.listeners.BottomSheetListener
import com.example.todolist.databinding.FragmentAddTaskBottomSheetBinding
import com.example.todolist.domain.entity.Tasks
import com.example.todolist.presentation.fragments.addTaskBottomSheet.viewModel.AddTaskViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddTaskBottomSheetFragment(private var listener: BottomSheetListener) :
    BottomSheetDialogFragment() {
    private lateinit var binding: FragmentAddTaskBottomSheetBinding
    private val viewModel: AddTaskViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddTaskBottomSheetBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        actions()
    }

    private fun actions() {
        binding.apply {
            confirmButton.setOnClickListener {
                viewModel.insertProducts(task())
                dismiss()
            }
        }
    }

    private fun task(): Tasks {
        binding.apply {
            return Tasks(
                title = taskNameEditText.text.toString(),
                description = taskDescriptionEditText.text.toString(),
            )
        }
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        listener?.onBottomSheetDismissed()
    }
}