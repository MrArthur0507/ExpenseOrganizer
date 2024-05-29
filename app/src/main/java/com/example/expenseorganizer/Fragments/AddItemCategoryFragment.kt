package com.example.expenseorganizer.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.expenseorganizer.Db.ExpenseTrackerApp
import com.example.expenseorganizer.entities.ItemCategory
import com.example.expenseorganizer.Factory.ItemCategoryViewModelFactory
import com.example.expenseorganizer.R
import com.example.expenseorganizer.viewModels.ItemCategoryViewModel

class AddItemCategoryFragment : Fragment() {

    private lateinit var viewModel: ItemCategoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_item_category, container, false)

        val editTextCategoryName = view.findViewById<EditText>(R.id.editTextCategoryName)
        val buttonSaveCategory = view.findViewById<Button>(R.id.buttonSaveCategory)

        val application = requireActivity().application as ExpenseTrackerApp
        val repository = application.repository
        val viewModelFactory = ItemCategoryViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ItemCategoryViewModel::class.java)

        buttonSaveCategory.setOnClickListener {
            val categoryName = editTextCategoryName.text.toString().trim()
            if (categoryName.isNotEmpty()) {
                val newItemCategory = ItemCategory(name = categoryName)
                viewModel.insert(newItemCategory)
                
            }
        }

        return view
    }
}