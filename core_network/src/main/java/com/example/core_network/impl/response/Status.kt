package com.example.core_network.impl.response

sealed class Status {

    data object Success : Status()

    data class Error(
        val message: String? = null
    ) : Status()
}