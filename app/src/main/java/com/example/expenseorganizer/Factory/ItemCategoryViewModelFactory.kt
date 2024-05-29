package com.example.expenseorganizer.Factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.expenseorganizer.Repositories.ItemCategoryRepository
import com.example.expenseorganizer.ViewModels.ItemCategoryViewModel


class ItemCategoryViewModelFactory(private val repository: ItemCategoryRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ItemCategoryViewModel::class.java)){
            return ItemCategoryViewModel(repository) as T
        }
        throw IllegalArgumentException("No such ViewModel class")
    }
}