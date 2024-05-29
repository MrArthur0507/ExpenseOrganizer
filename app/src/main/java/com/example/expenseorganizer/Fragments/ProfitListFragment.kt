package com.example.expenseorganizer.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expenseorganizer.Adapters.ProfitAdapter
import com.example.expenseorganizer.Db.ExpenseTrackerApp
import com.example.expenseorganizer.Factory.ProfitViewModelFactory
import com.example.expenseorganizer.R
import com.example.expenseorganizer.databinding.FragmentProfitListBinding
import com.example.expenseorganizer.viewModels.ProfitViewModel

class ProfitListFragment : Fragment() {

    private lateinit var binding: FragmentProfitListBinding
    private lateinit var profitViewModel: ProfitViewModel
    private lateinit var adapter: ProfitAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfitListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val repositoryProfit = (requireActivity().application as ExpenseTrackerApp).repositoryProfit
        val profitViewModelFactory = ProfitViewModelFactory(repositoryProfit)
        profitViewModel = ViewModelProvider(this, profitViewModelFactory).get(ProfitViewModel::class.java)

        adapter = ProfitAdapter()

        binding.recyclerViewProfit.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewProfit.adapter = adapter

        profitViewModel.allProfits.observe(viewLifecycleOwner, { profits ->
            adapter.setData(profits)
        })
    }
}