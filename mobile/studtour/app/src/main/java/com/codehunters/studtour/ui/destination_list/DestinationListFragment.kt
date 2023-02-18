package com.codehunters.studtour.ui.destination_list

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.codehunters.data.EntitiesData
import com.codehunters.studtour.R
import com.codehunters.studtour.adapters.DestinationsAdapter
import com.codehunters.studtour.databinding.FmtDestinationListBinding
import com.codehunters.studtour.utils.cancelNullable
import com.codehunters.studtour.utils.observe
import com.codehunters.studtour.utils.showSnackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job

@AndroidEntryPoint
class DestinationListFragment : Fragment(R.layout.fmt_destination_list) {

    companion object {
        const val SELECTED_TAB_KEY = "selected_tab_key"
    }

    private val viewBinding by viewBinding(FmtDestinationListBinding::bind)
    private val viewModel: DestinationListViewModel by viewModels()
    private val adapter = DestinationsAdapter(::onItemCLick)

    private var observerJob: Job? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.position = arguments?.getInt(SELECTED_TAB_KEY)
        viewBinding.destinations.adapter = adapter
        viewModel.isSearch.observe(this, observer = ::setObserver)
        viewModel.failureState.observe(this, observer = ::renderFailure)
    }

    private fun setObserver(isSearch: Boolean) {
        observerJob?.cancelNullable()
        observerJob = if (isSearch) {
            viewModel.uiSearchState.observe(this, observer = ::renderUiState)
        } else {
            viewModel.uiState.observe(this, observer = ::renderUiState)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun renderUiState(state: List<EntitiesData>) {
        viewBinding.found.text = "Найдено: ${state.size}"
        adapter.submitList(state)
        viewBinding.search.doOnTextChanged { query, _, _, _ ->
            viewModel.onSetIsSearch(query?.isNotEmpty() == true)
            viewModel.setQuery(query.toString())
        }
    }

    private fun renderFailure(throwable: Throwable) {
        viewBinding.root.showSnackbar(throwable.message ?: getString(R.string.error_default_text))
    }

    private fun onItemCLick(entityData: EntitiesData) {

    }
}