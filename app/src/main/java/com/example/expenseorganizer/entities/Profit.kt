package com.example.expenseorganizer.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "profit")
data class Profit(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val sum: Double,
    val description: String,
    val date: Date
)