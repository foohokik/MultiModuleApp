package com.example.core_database.impl.typeconverters

import androidx.room.TypeConverter
import com.example.core.data.model.AddressResponse
import com.google.gson.Gson

class AddressConverter {

    private val gson = Gson()

    @TypeConverter
    fun fromAddress(addressResponse: AddressResponse): String = gson.toJson(addressResponse)

    @TypeConverter
    fun toAddress (address: String): AddressResponse = gson.fromJson(address, AddressResponse::class.java)



}