package com.example.expenseorganizer.Db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.expenseorganizer.DAO.ItemCategoryDao
import com.example.expenseorganizer.Entities.ExpenseRecord
import com.example.expenseorganizer.Entities.ItemCategory

@Database(entities = [ItemCategory::class, ExpenseRecord::class], version = 1)
abstract class ExpenseTrackerRoomDb : RoomDatabase() {

    abstract fun ItemCategoryDao() : ItemCategoryDao
}