package com.example.categoryapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.categoryapp.data.model.CategoryList
import com.example.categoryapp.databinding.CategoryListItemBinding

class CategoryListAdapter :
    ListAdapter<CategoryList, CategoryListAdapter.ViewHolder>(CategoryListDiff()) {

    inner class ViewHolder(private val binding: CategoryListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(data: CategoryList) {
            with(binding) {
                ivThumbnail.setBackgroundResource(data.categoryImage)
                tvTitle.text = data.title
                tvSubtitle.text = data.description
            }
        }

    }

    class CategoryListDiff : DiffUtil.ItemCallback<CategoryList>() {
        override fun areItemsTheSame(oldItem: CategoryList, newItem: CategoryList): Boolean {
            return oldItem.title.contentEquals(newItem.title) && oldItem.description.contentEquals(
                newItem.description
            )
        }

        override fun areContentsTheSame(
            oldItem: CategoryList,
            newItem: CategoryList
        ) = oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            CategoryListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position).run { holder.bindData(this) }
    }
}