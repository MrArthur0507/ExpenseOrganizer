package com.example.expenseorganizer.Db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.expenseorganizer.DAO.ExpenseRecordDao
import com.example.expenseorganizer.DAO.ItemCategoryDao
import com.example.expenseorganizer.DAO.ProfitDao
import com.example.expenseorganizer.entities.ExpenseRecord
import com.example.expenseorganizer.entities.ItemCategory
import com.example.expenseorganizer.TypeConverters.DateConverter
import com.example.expenseorganizer.entities.Profit

@Database(entities = [ItemCategory::class, ExpenseRecord::class, Profit::class], version = 2)
@TypeConverters(DateConverter::class)
abstract class ExpenseTrackerRoomDb : RoomDatabase() {

    abstract fun ItemCategoryDao() : ItemCategoryDao
    abstract fun ExpenseRecordDao() : ExpenseRecordDao

    abstract fun ProfitDao() : ProfitDao
}