package com.example.search_feature_impl.data

import com.example.core_network.impl.JobApi
import com.example.core_network.impl.response.DataWrapper
import com.example.core_network.impl.response.HttpResultToDataWrapperConverter
import com.example.search_feature_impl.domain.model.Offers
import com.example.search_feature_impl.domain.model.toDataWrapperOffers
import com.example.search_feature_impl.domain.repo.RemoteSearchRepo
import javax.inject.Inject

class RemoteSearchRepoImpl @Inject constructor(
    private val api: JobApi,
    private val converter: HttpResultToDataWrapperConverter):RemoteSearchRepo {

    override suspend fun getOffers(): DataWrapper<Offers> {
        val result = api.getOffers()
        return converter.convert(result).toDataWrapperOffers()
    }


}