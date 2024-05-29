package com.example.expenseorganizer.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.expenseorganizer.databinding.ProfitItemBinding
import com.example.expenseorganizer.entities.Profit

class ProfitAdapter : RecyclerView.Adapter<ProfitAdapter.ProfitViewHolder>() {

    private var profits = listOf<Profit>()

    inner class ProfitViewHolder(private val binding: ProfitItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(profit: Profit) {
            binding.textViewProfitSum.text = profit.sum.toString()
            binding.textViewProfitDescription.text = profit.description
            binding.textViewProfitDate.text = profit.date.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfitViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ProfitItemBinding.inflate(inflater, parent, false)
        return ProfitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProfitViewHolder, position: Int) {
        val profit = profits[position]
        holder.bind(profit)
    }

    override fun getItemCount(): Int {
        return profits.size
    }

    fun setData(profits: List<Profit>) {
        this.profits = profits
        notifyDataSetChanged()
    }
}