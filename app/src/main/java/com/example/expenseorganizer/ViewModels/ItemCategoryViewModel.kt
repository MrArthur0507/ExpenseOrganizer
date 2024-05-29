package com.example.expenseorganizer.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.expenseorganizer.Entities.ItemCategory
import com.example.expenseorganizer.Repositories.ItemCategoryRepository
import kotlinx.coroutines.launch

class ItemCategoryViewModel(private val repository: ItemCategoryRepository) : ViewModel() {
    val allItemCategories = repository.allItemCategories.asLiveData()

    fun insert(itemCategory: ItemCategory) {
        viewModelScope.launch {
            repository.insert(itemCategory)
        }
    }
}