package com.example.expenseorganizer.Db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.expenseorganizer.DAO.ExpenseRecordDao
import com.example.expenseorganizer.DAO.ItemCategoryDao
import com.example.expenseorganizer.Entities.ExpenseRecord
import com.example.expenseorganizer.Entities.ItemCategory
import com.example.expenseorganizer.TypeConverters.DateConverter

@Database(entities = [ItemCategory::class, ExpenseRecord::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class ExpenseTrackerRoomDb : RoomDatabase() {

    abstract fun ItemCategoryDao() : ItemCategoryDao
    abstract fun ExpenseRecordDao() : ExpenseRecordDao
}