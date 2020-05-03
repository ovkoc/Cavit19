package com.ovkoc.cavit.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ovkoc.cavit.R
import com.ovkoc.cavit.common.base.BaseFragment
import com.ovkoc.cavit.common.extensions.hideKeyboard
import com.ovkoc.cavit.databinding.FragmentHomeBinding
import com.ovkoc.cavit.ui.home.model.CountryUIModel

class HomeFragment : BaseFragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    private lateinit var adapter: CountriesRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home,
            container, false
        )
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.getData()

        binding.swipeToRefreshLayout.setDistanceToTriggerSync(120)

        initializeRecyclerView()
        observers()

        return binding.root
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun observers() {
        viewModel.uiData.observe(viewLifecycleOwner, Observer {
            if (it.isNullOrEmpty()) {
                binding.contentLayout.visibility = View.GONE
                binding.messageLayout.visibility = View.VISIBLE
            } else {
                binding.contentLayout.visibility = View.VISIBLE
                binding.messageLayout.visibility = View.GONE
                adapter.setData(it)
            }
        })

        binding.swipeToRefreshLayout.setOnRefreshListener {
            viewModel.getData()
            binding.swipeToRefreshLayout.isRefreshing = false
            binding.homeToolbar.onCloseClicked(binding.swipeToRefreshLayout)
        }

        binding.homeToolbar.onSearchTextChangeListener {
            viewModel.filterUIData(it)
        }

        binding.countriesRecyclerView.setOnTouchListener { v, event ->
            v.hideKeyboard()
            false
        }

    }

    private fun initializeRecyclerView() {
        val recyclerView = binding.countriesRecyclerView
        val layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
        adapter = CountriesRecyclerViewAdapter()
        adapter.onItemClick = { item -> onCountryClicked(item) }

        recyclerView.adapter = adapter
    }

    private fun onCountryClicked(item: CountryUIModel) {

    }
}