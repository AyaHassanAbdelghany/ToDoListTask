package com.example.todolist.presentation.fragments.homeScreen.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.todolist.core.constants.CONSTANTS.DELETE
import com.example.todolist.core.constants.CONSTANTS.UPDATE
import com.example.todolist.core.listeners.BottomSheetListener
import com.example.todolist.core.listeners.ClickListener
import com.example.todolist.databinding.FragmentHomeScreenBinding
import com.example.todolist.presentation.fragments.addTaskBottomSheet.view.AddTaskBottomSheetFragment
import com.example.todolist.presentation.fragments.homeScreen.adapter.TasksAdapter
import com.example.todolist.presentation.fragments.homeScreen.viewModel.TasksViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeScreenFragment : Fragment(), ClickListener, BottomSheetListener {
    private lateinit var binding: FragmentHomeScreenBinding
    private val viewModel: TasksViewModel by viewModels()
    private lateinit var tasksAdapter: TasksAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeScreenBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        actions()
    }

    override fun onResume() {
        super.onResume()
        getTasks()
    }

    private fun actions() {
        binding.apply {
            deleteAll.setOnClickListener {
                viewModel.deleteAllTasks()

            }

            floatingActionButton.setOnClickListener {
                val bottomSheetFragment =
                    AddTaskBottomSheetFragment(listener = this@HomeScreenFragment)
                bottomSheetFragment.show(parentFragmentManager, bottomSheetFragment.tag)
            }
        }
    }

    private fun getTasks() {
        initRecyclerView()
        viewModel.getTasks()
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getProductsFromRoom.collect {
                if (it.isEmpty()) {
                    binding.apply {
                        emptyTasks.visibility = View.VISIBLE
                        deleteAll.visibility = View.GONE
                    }
                } else {
                    binding.apply {
                        emptyTasks.visibility = View.GONE
                        deleteAll.visibility = View.VISIBLE
                    }
                }
                tasksAdapter.differ.submitList(it)
            }

        }
    }

    private fun initRecyclerView() {
        tasksAdapter = TasksAdapter(this)
        binding.tasksRecyclerView.adapter = tasksAdapter
    }

    private fun updateTask(id: Long, isChecked: Boolean) {
        viewModel.updateTask(id = id, isCompleted = isChecked)
    }

    private fun deleteTaskById(id: Long) {
        viewModel.deleteTaskById(id = id)
    }

    override fun onItemClick(id: Long, isChecked: Boolean?, type: Int) {
        when (type) {
            DELETE -> deleteTaskById(id = id)
            UPDATE -> updateTask(id = id, isChecked = isChecked!!)
        }
    }

    override fun onBottomSheetDismissed() {
        getTasks()
    }
}