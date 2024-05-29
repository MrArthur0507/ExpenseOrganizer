package com.example.expenseorganizer.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.expenseorganizer.DAO.ExpenseRecordDao
import com.example.expenseorganizer.Db.ExpenseTrackerApp

class ExpenseRecordViewModel(application : Application) : AndroidViewModel(application) {
    private val expenseRecordDao : ExpenseRecordDao = ExpenseTrackerApp.database.ExpenseRecordDao()


}