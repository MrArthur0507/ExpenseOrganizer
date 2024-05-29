package com.example.expenseorganizer.Repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.example.expenseorganizer.DAO.ProfitDao
import com.example.expenseorganizer.entities.Profit

class ProfitRepository(private val profitDao: ProfitDao) {
    val allProfits: LiveData<List<Profit>> = profitDao.getAllProfits().asLiveData()

    suspend fun insert(profit: Profit) {
        profitDao.insert(profit)
    }
}