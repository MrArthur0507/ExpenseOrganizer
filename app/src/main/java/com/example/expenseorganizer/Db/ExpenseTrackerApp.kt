package com.example.expenseorganizer.Db

import android.app.Application
import androidx.room.Room

class ExpenseTrackerApp : Application() {
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