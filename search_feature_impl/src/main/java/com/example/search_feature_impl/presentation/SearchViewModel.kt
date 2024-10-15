package com.example.search_feature_impl.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.search_feature_impl.di.IoDispatcher
import com.example.search_feature_impl.domain.SearchFeatureInteractor
import com.example.search_feature_impl.presentation.adapter.CommonItemListener
import com.example.search_feature_impl.presentation.model.OffersUI
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SearchViewModel @AssistedInject constructor(
    private val interactor: SearchFeatureInteractor,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    private val mutableScreenStateFlow: MutableStateFlow<ScreenSearchState>,
    private val channel: Channel<SideEffects>
): ViewModel(), CommonItemListener {

    val screenStateFlow: StateFlow<ScreenSearchState> = mutableScreenStateFlow.asStateFlow()

    val sideEffects = channel.receiveAsFlow()

    init {
        getOffers()
    }



     fun getOffers()  {
        viewModelScope.launch(dispatcher) {
            interactor.getInitialData()
        }
    }


    override fun onVacancyClickListener(vacancy: OffersUI.VacancyUI) {
       viewModelScope.launch {
           channel.send(SideEffects.ClickEffectNavigation(vacancy))
       }
    }

    override fun onFavoriteIconClick(vacancy: OffersUI.VacancyUI) {
        viewModelScope.launch {
            interactor.updateVacancyIsFavorite(!vacancy.isFavorite, vacancy.id)
        }
        val list = screenStateFlow.value

        val newItems =  list.offers.map { offer ->
            if (offer is OffersUI.VacancyUI && offer == vacancy) {
                val newItem = offer.copy(isFavorite = !offer.isFavorite)
                newItem
            } else {
                offer
            }
        }
        mutableScreenStateFlow.update {
                it.copy(offers = newItems)
            }
    }

    override fun onClickButton() {
             viewModelScope.launch {
                 interactor.getFullVacancies()
             }
    }


    fun updateList () {
        viewModelScope.launch {
            interactor.updateVacancyList()
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(): SearchViewModel
    }
}