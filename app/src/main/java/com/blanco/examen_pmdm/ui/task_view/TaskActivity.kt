package com.blanco.examen_pmdm.ui.task_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.blanco.examen_pmdm.R
import com.blanco.examen_pmdm.databinding.ActivityTaskBinding

class TaskActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityTaskBinding
    private val binding: ActivityTaskBinding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}