package com.example.expenseorganizer.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item_category")
data class ItemCategory(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val name: String
)
