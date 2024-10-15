package com.example.core_network.impl.response

import retrofit2.Response

class HttpResultToDataWrapperConverter() {

    fun <T> convert(result: Response<T>): DataWrapper<T> {
        return if (result.isSuccessful) {
            DataWrapper(
                Status.Success,
                result.body()
            )
        } else {
            DataWrapper(
                Status.Error(result.message()),
                result.body()
            )
        }
    }
}