package com.example.search_feature_impl.domain


import com.example.core_network.impl.response.Status
import com.example.search_feature_impl.domain.model.Offers
import com.example.search_feature_impl.domain.repo.LocalSearchRepo
import com.example.search_feature_impl.domain.repo.RemoteSearchRepo
import com.example.search_feature_impl.presentation.ScreenSearchState
import com.example.search_feature_impl.presentation.SideEffects
import com.example.search_feature_impl.presentation.model.OffersUI
import com.example.search_feature_impl.presentation.model.toOffersListUI
import com.example.search_feature_impl.presentation.model.toVacanciesListUI
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class SearchFeatureInteractor @Inject constructor(
    private val localSearchRepo: LocalSearchRepo,
    private val remoteSearchRepo: RemoteSearchRepo,
    private val mutableScreenStateFlow: MutableStateFlow<ScreenSearchState>,
    private val channel: Channel<SideEffects>
)  {

    suspend fun getInitialData() {
        val remoteData = remoteSearchRepo.getOffers()
        when (remoteData.status) {
            is Status.Error -> channel.send(SideEffects.ErrorEffect((remoteData.status as Status.Error).message.orEmpty()))
            is Status.Success -> if (remoteData.data == null) {
                channel.send(SideEffects.ErrorEffect("Данные не загрузились"))
            } else {
                saveDataToDataBase(remoteData.data)
                val vacanciesUI = remoteData.data!!.vacancies!!.toVacanciesListUI()
                val offersUI = remoteData.data!!.offers!!.toOffersListUI()
                val quantityForBtn = vacanciesUI.size - 3
                if (remoteData.data!!.vacancies!!.size > 3) {
                    mutableScreenStateFlow.update { state ->
                        state.copy(
                            offers =
                            listOf(OffersUI.CommonList(offersUI)) + listOf(OffersUI.Header()) + vacanciesUI.take(
                                3
                            ) + listOf(
                                OffersUI.QuantityOfVacanciesButton(quantityForBtn)
                            ),  numberOfVacancies = vacanciesUI.size
                        )
                    }
                } else {
                    mutableScreenStateFlow.update { state ->
                        state.copy(
                            offers =
                            listOf(OffersUI.CommonList(offersUI)) + listOf(OffersUI.Header()) + vacanciesUI
                        )
                    }
                }
            }
        }
    }

    private suspend fun saveDataToDataBase(offers : Offers?) {
        localSearchRepo.saveVacancies(offers?.vacancies)
        localSearchRepo.saveOffers(offers?.offers)
    }

    suspend fun getFullVacancies() {
        val vacanciesUI = localSearchRepo.getAllVacancies().toVacanciesListUI()
        val offersUI = localSearchRepo.getAllOffers().toOffersListUI()
        mutableScreenStateFlow.update { state -> state.copy(
            offers = listOf(OffersUI.CommonList(offersUI)) + listOf(OffersUI.Header()) + vacanciesUI,
            isFullVacanciesList = true)
        }
    }

    suspend fun updateVacancyIsFavorite (isFavorite: Boolean, id: String) = localSearchRepo.updateVacancyIsFavorite(isFavorite, id)

    suspend fun updateVacancyList ()  {
        val vacanciesUI = localSearchRepo.getAllVacancies().toVacanciesListUI()
        val offersUI = localSearchRepo.getAllOffers().toOffersListUI()
        val isFullVacanciesList = mutableScreenStateFlow.value.isFullVacanciesList
        if(isFullVacanciesList) {
            mutableScreenStateFlow.update {
                    state -> state.copy(
                offers = listOf(OffersUI.CommonList(offersUI)) + listOf(OffersUI.Header()) + vacanciesUI)
            }
        } else  {
            val quantityForBtn = vacanciesUI.size - 3
            mutableScreenStateFlow.update {state ->
                state.copy(offers =
                listOf(OffersUI.CommonList(offersUI)) +
                        listOf(OffersUI.Header())
                        + vacanciesUI.take(3) + listOf(OffersUI.QuantityOfVacanciesButton(quantityForBtn))
                )
            }
        }
    }






}