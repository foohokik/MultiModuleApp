package com.example.core_network.impl.response

class DataWrapper<T>(
    val status: Status,
    val data: T? = null
)