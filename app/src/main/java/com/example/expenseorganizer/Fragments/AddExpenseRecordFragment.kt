package com.example.expenseorganizer.Fragments

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.expenseorganizer.Db.ExpenseTrackerApp
import com.example.expenseorganizer.Factory.ExpenseRecordViewModelFactory
import com.example.expenseorganizer.Factory.ItemCategoryViewModelFactory
import com.example.expenseorganizer.entities.ExpenseRecord
import com.example.expenseorganizer.entities.ItemCategory
import com.example.expenseorganizer.viewModels.ExpenseRecordViewModel
import com.example.expenseorganizer.viewModels.ItemCategoryViewModel
import com.example.expenseorganizer.databinding.FragmentAddExpenseRecordBinding
import java.util.Date


class AddExpenseRecordFragment : Fragment() {

    private lateinit var binding: FragmentAddExpenseRecordBinding
    private lateinit var itemCategoryViewModel: ItemCategoryViewModel
    private lateinit var expenseRecordViewModel: ExpenseRecordViewModel
    private var selectedCategoryId: Int = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddExpenseRecordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override  fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val repositoryExpense = (requireActivity().application as ExpenseTrackerApp).repositoryExpense
        val expenseViewModelFactory = ExpenseRecordViewModelFactory(repositoryExpense)
        val repositoryCategory = (requireActivity().application as ExpenseTrackerApp).repository
        val categoryViewModelFactory = ItemCategoryViewModelFactory(repositoryCategory)


        expenseRecordViewModel = ViewModelProvider(this, expenseViewModelFactory).get(ExpenseRecordViewModel::class.java)
        itemCategoryViewModel = ViewModelProvider(this, categoryViewModelFactory).get(ItemCategoryViewModel::class.java)

        itemCategoryViewModel.allItemCategories.observe(viewLifecycleOwner, { categories ->
            setupCategoryDropdown(categories)
        })

        binding.btnAddExpenseRecord.setOnClickListener {
            addExpenseRecord()
        }
    }

    private fun setupCategoryDropdown(categories: List<ItemCategory>) {
        val categoryNames = categories.map { it.name }
        val adapter = ArrayAdapter(requireContext(), R.layout.simple_spinner_item, categoryNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerCategory.adapter = adapter

        binding.spinnerCategory.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                selectedCategoryId = categories[position].id
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }

    private fun addExpenseRecord() {
        val priceStr = binding.etPrice.text.toString()
        val name = binding.etName.text.toString()
        val price = priceStr.toDoubleOrNull()

        if (price != null && selectedCategoryId != -1 && name.isNotEmpty()) {
            val expenseRecord = ExpenseRecord(categoryId = selectedCategoryId, price = price, name = name, date = Date())

            expenseRecordViewModel.insert(expenseRecord)

        } else {

        }
    }
}
