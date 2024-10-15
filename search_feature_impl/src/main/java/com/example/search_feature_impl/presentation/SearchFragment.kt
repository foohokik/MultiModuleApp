package com.example.search_feature_impl.presentation

import android.os.Bundle
import android.view.View
import androidx.core.net.toUri
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.core_utils.extensions.lazyViewModel
import com.example.core_utils.presentation.BaseFragmentBinding
import com.example.search_feature_impl.databinding.FragmentSearchBinding
import com.example.search_feature_impl.di.SearchFeatureComponentHolder
import com.example.search_feature_impl.presentation.adapter.SearchAdapter
import kotlinx.coroutines.launch

class SearchFragment :
    BaseFragmentBinding<FragmentSearchBinding>(FragmentSearchBinding::inflate) {


    private val viewModel: SearchViewModel by lazyViewModel {
        SearchFeatureComponentHolder.getComponent().getSearchViewModelFactory().create()
    }

    private lateinit var searchAdapter: SearchAdapter

    init {
        SearchFeatureComponentHolder.getComponent().inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSearchRecycleView()
        observe()

    }

    private fun initUI(qty: Int?) {
        val vacanciesText = qty?.let {
            requireContext().resources.getQuantityString(
                com.example.core_utils.R.plurals.plurals_vacancies_full, qty, qty
            )
        }
        binding.tvVacaancies.text = vacanciesText
    }

    private fun observe() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.screenStateFlow.collect {
                        searchAdapter.items = it.offers
                        initUI(it.numberOfVacancies)
                    }
                }
                launch { viewModel.sideEffects.collect { handleSideEffects(it) } }
            }
        }
    }


    private fun initSearchRecycleView() {
        with(binding.rvSearchFragment) {
            searchAdapter = SearchAdapter(viewModel)
            adapter = searchAdapter
            itemAnimator = null
        }
    }

    private fun handleSideEffects(sideEffects: SideEffects) {
        when (sideEffects) {
            is SideEffects.ErrorEffect -> Unit
            is SideEffects.ExceptionEffect -> Unit
            is SideEffects.ClickEffectNavigation -> {
                findNavController().navigate("app://full_vacancy/${sideEffects.item.id}".toUri())
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.updateList()
    }

}