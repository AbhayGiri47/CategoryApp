package com.example.categoryapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.categoryapp.data.model.Category
import com.example.categoryapp.databinding.CategoryImageItemBinding


class CategoryImageAdapter :
    ListAdapter<Category, CategoryImageAdapter.ViewHolder>(CategoryDiff()) {

    inner class ViewHolder(private val binding: CategoryImageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(data: Category) {
            binding.root.setBackgroundResource(data.imageRes)
        }
    }

    class CategoryDiff : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem.type.ordinal == newItem.type.ordinal
        }

        override fun areContentsTheSame(
            oldItem: Category,
            newItem: Category
        ) = oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            CategoryImageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position).run { holder.bindData(this) }
    }
}