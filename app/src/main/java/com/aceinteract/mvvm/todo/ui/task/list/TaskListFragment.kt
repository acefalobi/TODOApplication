package com.aceinteract.mvvm.todo.ui.task.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.aceinteract.mvvm.todo.data.KamikazeObserver
import com.aceinteract.mvvm.todo.data.entity.Task
import com.aceinteract.mvvm.todo.databinding.TaskListFragmentBinding

class TaskListFragment : Fragment() {

    private lateinit var viewModel: TaskListViewModel

    private lateinit var binding: TaskListFragmentBinding

    private val actionListener = object : TaskActionListener {
        override fun onTaskClicked(task: Task) {
            // Do nothing
        }

        override fun onTaskDeleted(task: Task) {
            viewModel.deleteTask(task)
        }

        override fun onTaskCompleted(task: Task) {
            viewModel.markAsCompleted(task)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(TaskListViewModel::class.java)
        binding = TaskListFragmentBinding.inflate(inflater, container, false).apply {
            rvTasks.adapter = TaskListAdapter(actionListener)
        }

        subscribeTasks()

        return binding.root
    }

    private fun subscribeTasks() {
        viewModel.tasks.observe(viewLifecycleOwner, object : KamikazeObserver<List<Task>>() {

            override fun onTriggered(t: List<Task>) {
                viewModel.taskList.apply {
                    clear()
                    addAll(t)
                }
            }

        })
    }

}
