package com.blanco.examen_pmdm.ui.initial_view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.blanco.examen_pmdm.R
import com.blanco.examen_pmdm.databinding.ActivityMainBinding
import com.blanco.examen_pmdm.databinding.ActivityTaskBinding
import com.blanco.examen_pmdm.ui.task_view.TaskActivity


class MainActivity : AppCompatActivity() {


    private lateinit var _binding: ActivityMainBinding
    private val binding: ActivityMainBinding get() = _binding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAccess.setOnClickListener {
            saveDepartmentName()
        }
    }

    private fun saveDepartmentName() {
        val name = binding.etDepartment.text.toString().trim()
        if (!name.isNullOrEmpty()) {
            viewModel.saveDepartment(this, name)
            goToTaskScreen()
        } else {
            Toast.makeText(this, "introduce el departamento", Toast.LENGTH_SHORT).show()
        }
    }

    private fun goToTaskScreen() {
        val intent = Intent(this, TaskActivity::class.java)
        startActivity(intent)
        finish()

    }
}