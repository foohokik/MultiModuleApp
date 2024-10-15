package com.example.full_vacancy_feature_impl.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.full_vacancy_feature_impl.domain.FullVacancyFeatureInteractor
import com.example.full_vacancy_feature_impl.presentation.model.VacancyUI
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FullVacancyViewModel @AssistedInject constructor(
    private val interactor: FullVacancyFeatureInteractor,
    @Assisted savedStateHandle: SavedStateHandle
) : ViewModel() {

    var id: String? = null

    private val _contentVacancyState = MutableStateFlow(VacancyUI())
    val contentVacancyState = _contentVacancyState.asStateFlow()

    init {
        id = savedStateHandle["id"]
        id?.let { getVacancyById(it) }
    }

    private fun getVacancyById(id: String) {
        viewModelScope.launch {
            _contentVacancyState.value = interactor.getVacancyById(id)
        }
    }

    fun onFavoriteIconClick() {
        val vacancy = contentVacancyState.value
        viewModelScope.launch {
            interactor.updateVacancyIsFavorite(!vacancy.isFavorite, vacancy.id)
            _contentVacancyState.update {
                it.copy(isFavorite = !vacancy.isFavorite)
            }
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(@Assisted savedStateHandle: SavedStateHandle): FullVacancyViewModel
    }

}