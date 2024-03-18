package com.blanco.examen_pmdm.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.blanco.examen_pmdm.data.network.model.TaskResponse
import com.blanco.examen_pmdm.databinding.ItemBaseBinding

class TaskAdapter () :
    ListAdapter<TaskResponse, TaskAdapter.BaseViewHolder>(BaseItemCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBaseBinding.inflate(inflater, parent, false)
        return BaseViewHolder(binding)

    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val item = getItem(position)
        //TODO pintar datos
        holder.binding.tvTitle.text = item.taskTitle
        holder.binding.tvEmploye.text = item.employee
        holder.binding.tvProjectDepartment.text = item.project.department
        holder.binding.tvProjectDeadLine.text = item.project.projectDeadLine
    }


    inner class BaseViewHolder(val binding: ItemBaseBinding) : RecyclerView.ViewHolder(binding.root)

}

object BaseItemCallBack : DiffUtil.ItemCallback<TaskResponse>() {
    override fun areItemsTheSame(oldItem: TaskResponse, newItem: TaskResponse): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TaskResponse, newItem: TaskResponse): Boolean {
        return oldItem == newItem
    }

}