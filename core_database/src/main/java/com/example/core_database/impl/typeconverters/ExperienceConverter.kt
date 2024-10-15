package com.example.core_database.impl.typeconverters

import androidx.room.TypeConverter
import com.example.core.data.model.ExperienceResponse
import com.google.gson.Gson

class ExperienceConverter {

    private val gson = Gson()

    @TypeConverter
    fun fromExperience(value: ExperienceResponse): String = gson.toJson(value)

    @TypeConverter
    fun toExperience (value: String): ExperienceResponse = gson.fromJson(value, ExperienceResponse::class.java)

}