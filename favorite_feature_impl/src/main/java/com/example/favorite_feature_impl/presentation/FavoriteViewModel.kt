package com.example.favorite_feature_impl.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.favorite_feature_impl.domain.FavoriteFeatureInteractor
import com.example.favorite_feature_impl.presentation.adapter.VacancyItemListener
import com.example.favorite_feature_impl.presentation.model.VacancyUI
import com.example.favorite_feature_impl.presentation.model.toVacanciesListUI
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FavoriteViewModel @AssistedInject constructor(
    private val interactor: FavoriteFeatureInteractor
) : ViewModel(), VacancyItemListener {

    private val _vacanciesFlow = MutableStateFlow(emptyList<VacancyUI>())
    val vacanciesFlow = _vacanciesFlow.asStateFlow()

    private val _sideEffects = Channel<SideEffects>()
    val sideEffects = _sideEffects.receiveAsFlow()

    init {
        getVacancies()
    }

    fun getVacancies() {
        viewModelScope.launch {
            val result = interactor.getAllVacancies().toVacanciesListUI()
            _vacanciesFlow.value = result
        }
    }

    override fun onVacancyClickListener(vacancy: VacancyUI) {
        viewModelScope.launch {
            _sideEffects.send(SideEffects.ClickEffectNavigation(vacancy))
        }
    }

    override fun onFavoriteIconClick(vacancy: VacancyUI) {
        viewModelScope.launch {
            interactor.updateVacancyIsFavorite(!vacancy.isFavorite, vacancy.id)
        }
        val list = _vacanciesFlow.value.toMutableList()
        val index = list.indexOf(vacancy)
        list[index] = vacancy.copy(isFavorite = !vacancy.isFavorite)

        _vacanciesFlow.update {
            list
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(): FavoriteViewModel
    }

}