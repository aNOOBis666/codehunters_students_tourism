package com.codehunters.studtour.ui.destination_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codehunters.data.DormitoryInfo
import com.codehunters.data.EntitiesData
import com.codehunters.data.LabInfo
import com.codehunters.presenter.interfaces.IStudTourPresenter
import com.codehunters.studtour.interactors.search
import com.codehunters.studtour.interactors.searchQuery
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class DestinationListViewModel @Inject constructor(
    private val studTourPresenter: IStudTourPresenter
): ViewModel() {

    companion object {
        private const val SEARCH_DEBOUNCE_SEC = 2L
        const val DORMITORIES_TAB_POSITION = 0
        const val SCIENCE_TAB_POSITION = 1
    }

    var position: Int? = DORMITORIES_TAB_POSITION

    private val _uiState = MutableStateFlow<List<EntitiesData>>(emptyList())
    val uiState = _uiState.asStateFlow()

    private val _uiSearchState = MutableStateFlow<List<EntitiesData>>(emptyList())
    val uiSearchState = _uiSearchState.asStateFlow()

    private val _failureState = MutableSharedFlow<Throwable>(replay = 0)
    val failureState = _failureState.asSharedFlow()

    private val _searchQueryState = MutableSharedFlow<String>(
        replay = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )
    val searchQueryState = _searchQueryState.asSharedFlow()

    private val _isSearch = MutableStateFlow(false)
    val isSearch = _isSearch.asStateFlow()

    init {
        @OptIn(FlowPreview::class)
        searchQueryState
            .debounce(TimeUnit.SECONDS.toMillis(SEARCH_DEBOUNCE_SEC))
            .filter(String::isNotEmpty)
            .onEach(::search)
            .launchIn(viewModelScope)
        onLoad()
    }

    fun onSetIsSearch(isSearch: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            _isSearch.value = isSearch
        }
    }

    fun setQuery(query: String = String()) {
        viewModelScope.launch(Dispatchers.IO) {
            _searchQueryState.emit(query)
        }
    }

    private fun onLoad() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                when (position) {
                    DORMITORIES_TAB_POSITION -> studTourPresenter.getDormitories()
                    SCIENCE_TAB_POSITION -> studTourPresenter.getLabs()
                    else -> emptyList()
                }
            }.onSuccess {
                _uiState.value = it
            }.onFailure {
                _failureState.tryEmit(it)
            }
        }
    }

    private fun search(query: String = String()) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                when (position) {
                    DORMITORIES_TAB_POSITION -> uiState.value.map { it as DormitoryInfo }.search(query)
                    SCIENCE_TAB_POSITION -> uiState.value.map { it as LabInfo }.searchQuery(query)
                    else -> emptyList()
                }
            }.onSuccess {
                _uiSearchState.value = it
            }.onFailure {
                _failureState.tryEmit(it)
            }
        }
    }
}