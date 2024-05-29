package com.example.expenseorganizer.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.expenseorganizer.entities.ExpenseRecord
import com.example.expenseorganizer.Repositories.ExpenseRecordRepository
import kotlinx.coroutines.launch

class ExpenseRecordViewModel(private val repository: ExpenseRecordRepository) : ViewModel() {

    val allExpenseRecords: LiveData<List<ExpenseRecord>> = repository.allExpenseRecords.asLiveData()
    fun insert(expenseRecord: ExpenseRecord)  {
        viewModelScope.launch {
            repository.insert(expenseRecord)
        }

    }
}


