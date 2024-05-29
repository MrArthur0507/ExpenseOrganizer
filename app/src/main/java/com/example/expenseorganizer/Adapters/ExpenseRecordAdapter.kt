package com.example.expenseorganizer.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.expenseorganizer.databinding.ExpenseRecordItemBinding
import com.example.expenseorganizer.entities.ExpenseRecord



class ExpenseRecordAdapter : RecyclerView.Adapter<ExpenseRecordAdapter.ExpenseRecordViewHolder>() {

    private var expenseRecords = listOf<ExpenseRecord>()

    inner class ExpenseRecordViewHolder(private val binding: ExpenseRecordItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(expenseRecord: ExpenseRecord) {
            binding.textViewExpenseName.text = expenseRecord.name;
            binding.textViewExpenseDate.text = expenseRecord.date.toString();
            binding.textViewExpensePrice.text = expenseRecord.price.toString();
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseRecordViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ExpenseRecordItemBinding.inflate(inflater, parent, false)
        return ExpenseRecordViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExpenseRecordViewHolder, position: Int) {
        val expenseRecord = expenseRecords[position]
        holder.bind(expenseRecord)
    }

    override fun getItemCount(): Int {
        return expenseRecords.size
    }

    fun setData(expenseRecords: List<ExpenseRecord>) {
        this.expenseRecords = expenseRecords
        notifyDataSetChanged()
    }
}