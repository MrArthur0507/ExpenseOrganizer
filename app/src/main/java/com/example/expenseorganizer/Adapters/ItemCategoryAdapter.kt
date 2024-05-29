package com.example.expenseorganizer.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.expenseorganizer.Entities.ItemCategory
import com.example.expenseorganizer.databinding.ItemCategoryBinding

class ItemCategoryAdapter : RecyclerView.Adapter<ItemCategoryAdapter.ItemCategoryViewHolder>() {

    private var categories = listOf<ItemCategory>()

    inner class ItemCategoryViewHolder(private val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(category: ItemCategory) {
            binding.textViewCategoryName.text = category.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCategoryViewHolder {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemCategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemCategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.bind(category)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    fun setData(categories: List<ItemCategory>) {
        this.categories = categories
        notifyDataSetChanged()
    }
}