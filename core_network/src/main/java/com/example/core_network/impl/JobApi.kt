package com.example.core_network.impl

import com.example.core.data.model.OffersResponse
import retrofit2.Response
import retrofit2.http.GET

interface JobApi {

    @GET("/u/0/uc?id=1z4TbeDkbfXkvgpoJprXbN85uCcD7f00r&export=download")
    suspend fun getOffers(): Response<OffersResponse>

}