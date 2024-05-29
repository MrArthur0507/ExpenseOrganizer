package com.example.expenseorganizer.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.expenseorganizer.Db.ExpenseTrackerApp
import com.example.expenseorganizer.Factory.ProfitViewModelFactory
import com.example.expenseorganizer.R
import com.example.expenseorganizer.databinding.FragmentAddProfitBinding
import com.example.expenseorganizer.entities.Profit
import com.example.expenseorganizer.viewModels.ProfitViewModel
import java.util.Date

class AddProfitFragment : Fragment() {
private lateinit var binding: FragmentAddProfitBinding
private lateinit var profitViewModel: ProfitViewModel

override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
): View? {
    binding = FragmentAddProfitBinding.inflate(inflater, container, false)
    return binding.root
}

override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val repositoryProfit = (requireActivity().application as ExpenseTrackerApp).repositoryProfit
    val profitViewModelFactory = ProfitViewModelFactory(repositoryProfit)
    profitViewModel = ViewModelProvider(this, profitViewModelFactory).get(ProfitViewModel::class.java)

    binding.btnAddProfit.setOnClickListener {
        addProfit()
    }
}

private fun addProfit() {
    val sumStr = binding.etSum.text.toString()
    val description = binding.etDescription.text.toString()
    val sum = sumStr.toDoubleOrNull()

    if (sum != null && description.isNotEmpty()) {
        val profit = Profit(sum = sum, description = description, date = Date())
        profitViewModel.insert(profit)
    } else {
    }
}
}