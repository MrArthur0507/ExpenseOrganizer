package com.example.expenseorganizer.Factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.expenseorganizer.Repositories.ExpenseRecordRepository
import com.example.expenseorganizer.viewModels.ExpenseRecordViewModel

class ExpenseRecordViewModelFactory(private val repository: ExpenseRecordRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ExpenseRecordViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ExpenseRecordViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}