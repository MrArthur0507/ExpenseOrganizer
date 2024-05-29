package com.example.expenseorganizer.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.expenseorganizer.entities.ExpenseRecord
import kotlinx.coroutines.flow.Flow


@Dao
interface ExpenseRecordDao {
    @Insert
    suspend fun insert(expenseRecord: ExpenseRecord)

    @Query("SELECT * FROM expense_record")
    fun getAllExpenseRecords(): Flow<List<ExpenseRecord>>
}