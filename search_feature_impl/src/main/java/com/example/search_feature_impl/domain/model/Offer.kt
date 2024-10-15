package com.example.search_feature_impl.domain.model

import java.io.Serializable


data class Offer(
    val button: String = "",
    val id: String,
    val link: String,
    val title: String,
): Serializable