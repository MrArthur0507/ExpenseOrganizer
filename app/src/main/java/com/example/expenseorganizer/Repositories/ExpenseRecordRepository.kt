package com.example.expenseorganizer.Repositories

import com.example.expenseorganizer.DAO.ExpenseRecordDao
import com.example.expenseorganizer.entities.ExpenseRecord
import kotlinx.coroutines.flow.Flow

class ExpenseRecordRepository(private val expenseRecordDao: ExpenseRecordDao) {

    val allExpenseRecords: Flow<List<ExpenseRecord>> = expenseRecordDao.getAllExpenseRecords()

    suspend fun insert(expenseRecord: ExpenseRecord) {
        expenseRecordDao.insert(expenseRecord)
    }
}