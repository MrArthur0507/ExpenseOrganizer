package com.example.expenseorganizer.Repositories

import com.example.expenseorganizer.DAO.ItemCategoryDao
import com.example.expenseorganizer.entities.ItemCategory
import kotlinx.coroutines.flow.Flow

class ItemCategoryRepository(private val itemCategoryDao: ItemCategoryDao) {
    val allItemCategories: Flow<List<ItemCategory>> = itemCategoryDao.getAllCategories()

    suspend fun insert(itemCategory: ItemCategory) {
        itemCategoryDao.insert(itemCategory)
    }
}