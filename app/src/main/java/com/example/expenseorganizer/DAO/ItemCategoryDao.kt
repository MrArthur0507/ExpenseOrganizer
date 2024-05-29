package com.example.expenseorganizer.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.expenseorganizer.Entities.ItemCategory
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemCategoryDao {
    @Insert
    suspend fun insert(itemCategory: ItemCategory)

    @Query("SELECT * FROM item_category")
    fun getAllCategories(): Flow<List<ItemCategory>>
}