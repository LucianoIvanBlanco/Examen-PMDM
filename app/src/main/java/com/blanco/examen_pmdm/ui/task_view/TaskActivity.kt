package com.blanco.examen_pmdm.ui.task_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.blanco.examen_pmdm.databinding.ActivityTaskBinding
import com.blanco.examen_pmdm.ui.adapter.TaskAdapter
import kotlinx.coroutines.launch

class TaskActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityTaskBinding
    private val binding: ActivityTaskBinding get() = _binding

    private val viewModel: TaskViewModel by viewModels()
    private val adapter: TaskAdapter = TaskAdapter()


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            _binding = ActivityTaskBinding.inflate(layoutInflater)
            setContentView(binding.root)

            binding.rvTask.layoutManager = LinearLayoutManager(this)
            binding.rvTask.adapter = adapter

            viewModel.getDepartment(this)
            observerViewModel()

        }

        private fun observerViewModel() {
            viewModel.department.observe(this) { userName ->
                if (userName != null) {
                    viewModel.getHomeWork(userName)
                }
            }


            viewModel.uiState.observe(this) { uiState ->
                if (uiState.response != null) {
                    adapter.submitList(uiState.response)
                }


                if (uiState.isLoading) {
                    //Mostrar carga
                } else {
                    //OCULTAR carga
                }

                if (uiState.isError) {
                    //mostrar error
                }
            }


            lifecycleScope.launch {
                viewModel.uiState2.collect{response->
                }

                viewModel.uiState2.collect{ response->
                }
            }

        }


    }