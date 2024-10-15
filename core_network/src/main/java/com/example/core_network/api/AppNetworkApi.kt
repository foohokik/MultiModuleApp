package com.example.core_network.api

import com.example.core_network.impl.JobApi
import com.example.core_network.impl.response.HttpResultToDataWrapperConverter
import com.example.module_injector.BaseAPI

interface AppNetworkApi: BaseAPI {
   fun getJobApi(): JobApi
   fun getConvertorForResponse():HttpResultToDataWrapperConverter
}