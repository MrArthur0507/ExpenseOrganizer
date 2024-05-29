package com.example.expenseorganizer.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.expenseorganizer.Adapters.ItemCategoryAdapter
import com.example.expenseorganizer.Db.ExpenseTrackerApp
import com.example.expenseorganizer.Entities.ItemCategory
import com.example.expenseorganizer.Factory.ItemCategoryViewModelFactory
import com.example.expenseorganizer.R
import com.example.expenseorganizer.ViewModels.ItemCategoryViewModel

class ItemCategoryFragment : Fragment() {

    private lateinit var viewModel: ItemCategoryViewModel
    private lateinit var adapter: ItemCategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_item_category2, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        adapter = ItemCategoryAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        val repository = (requireActivity().application as ExpenseTrackerApp).repository
        val viewModelFactory = ItemCategoryViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ItemCategoryViewModel::class.java)
        viewModel.allItemCategories.observe(viewLifecycleOwner, Observer { categories ->
            adapter.setData(categories)
        })

        return view
    }
}
