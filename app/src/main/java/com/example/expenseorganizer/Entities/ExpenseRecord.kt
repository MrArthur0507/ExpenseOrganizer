package com.example.expenseorganizer.Entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date

@Entity(
    tableName = "expense_record",
    foreignKeys = [ForeignKey(
        entity = ItemCategory::class,
        parentColumns = ["id"],
        childColumns = ["categoryId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class ExpenseRecord(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val categoryId: Int,
    val price: Double,
    val name: String,
    val date: Date
)
