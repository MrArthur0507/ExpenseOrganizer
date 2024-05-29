package com.example.expenseorganizer.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.expenseorganizer.Entities.ExpenseRecord


@Dao
interface ExpenseRecordDao {
    @Insert
    suspend fun insert(expenseRecord: ExpenseRecord)

    @Query("SELECT * FROM expense_record")
    suspend fun getAllExpenseRecords(): List<ExpenseRecord>
}