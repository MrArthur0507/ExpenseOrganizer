package com.example.expenseorganizer.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expenseorganizer.Adapters.ExpenseRecordAdapter
import com.example.expenseorganizer.Db.ExpenseTrackerApp
import com.example.expenseorganizer.Factory.ExpenseRecordViewModelFactory
import com.example.expenseorganizer.Factory.ItemCategoryViewModelFactory
import com.example.expenseorganizer.R
import com.example.expenseorganizer.viewModels.ExpenseRecordViewModel
import com.example.expenseorganizer.databinding.FragmentExpenseRecordBinding
import com.example.expenseorganizer.entities.ExpenseRecord

class ExpenseRecordFragment : Fragment() {

    private lateinit var binding: FragmentExpenseRecordBinding
    private lateinit var viewModel: ExpenseRecordViewModel
    private lateinit var adapter: ExpenseRecordAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExpenseRecordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val repository = (requireActivity().application as ExpenseTrackerApp).repositoryExpense
        val viewModelFactory = ExpenseRecordViewModelFactory(repository)

        viewModel =
            ViewModelProvider(this, viewModelFactory).get(ExpenseRecordViewModel::class.java)


        adapter = ExpenseRecordAdapter()
        binding.recyclerViewExpenseRecord.adapter = adapter
        binding.recyclerViewExpenseRecord.layoutManager = LinearLayoutManager(requireContext())


        viewModel.allExpenseRecords.observe(viewLifecycleOwner, Observer { expenseRecords ->
            adapter.setData(expenseRecords)
        })

        binding.btnShareExpense.setOnClickListener {
            shareExpense()
        }

    }

    fun shareExpense() {

        val expenseRecord = viewModel.allExpenseRecords.value?.firstOrNull()

        if (expenseRecord != null) {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, formatExpenseDetails(expenseRecord))
            }
            startActivity(Intent.createChooser(shareIntent, "Share expense via"))
        }
    }

    fun formatExpenseDetails(expenseRecord: ExpenseRecord): String {
        return "Expense Details:\n" +
                "Name: ${expenseRecord.name}\n" +
                "Price: ${expenseRecord.price}\n" +
                "Date: ${expenseRecord.date}\n" +
                "Category: ${expenseRecord.categoryId}"
    }
}


