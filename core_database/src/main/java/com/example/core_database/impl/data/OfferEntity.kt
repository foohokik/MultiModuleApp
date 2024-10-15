package com.example.core_database.impl.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "offers"
)
data class OfferEntity(
    val button: String,
     @PrimaryKey(autoGenerate = false)val id: String,
    val link: String,
    val title: String
)
