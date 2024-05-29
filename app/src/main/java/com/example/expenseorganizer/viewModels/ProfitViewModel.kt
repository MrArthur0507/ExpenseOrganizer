package com.example.expenseorganizer.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expenseorganizer.Repositories.ProfitRepository
import com.example.expenseorganizer.entities.Profit
import kotlinx.coroutines.launch

class ProfitViewModel(private val repository: ProfitRepository) : ViewModel() {
    val allProfits: LiveData<List<Profit>> = repository.allProfits

    fun insert(profit: Profit)  {
        viewModelScope.launch {
            repository.insert(profit)
        }

    }
}