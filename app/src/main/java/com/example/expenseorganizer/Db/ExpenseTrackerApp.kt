package com.example.expenseorganizer.Db

import android.app.Application
import androidx.room.Room
import com.example.expenseorganizer.Repositories.ExpenseRecordRepository
import com.example.expenseorganizer.Repositories.ItemCategoryRepository
import com.example.expenseorganizer.Repositories.ProfitRepository

class ExpenseTrackerApp : Application() {
    val repository by lazy { ItemCategoryRepository(database.ItemCategoryDao()) }
    val repositoryExpense by lazy { ExpenseRecordRepository(database.ExpenseRecordDao()) }
    val repositoryProfit by lazy { ProfitRepository(database.ProfitDao())}
    companion object {
        lateinit var database: ExpenseTrackerRoomDb
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            applicationContext,
            ExpenseTrackerRoomDb::class.java, "expense_organizer_db"
        ).build()
    }
}