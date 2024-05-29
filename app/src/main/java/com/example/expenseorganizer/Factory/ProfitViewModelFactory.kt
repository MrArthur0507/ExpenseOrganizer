package com.example.expenseorganizer.Factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.expenseorganizer.Repositories.ProfitRepository
import com.example.expenseorganizer.viewModels.ItemCategoryViewModel
import com.example.expenseorganizer.viewModels.ProfitViewModel

class ProfitViewModelFactory(private val repository: ProfitRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProfitViewModel::class.java)){
            return ProfitViewModel(repository) as T
        }
        throw IllegalArgumentException("No such ViewModel class")
    }
}