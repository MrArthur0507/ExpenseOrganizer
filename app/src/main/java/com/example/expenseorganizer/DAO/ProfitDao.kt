package com.example.expenseorganizer.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.expenseorganizer.entities.Profit
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfitDao {
    @Insert
    suspend fun insert(profit: Profit)

    @Query("SELECT * FROM profit ORDER BY date DESC")
    fun getAllProfits(): Flow<List<Profit>>
}