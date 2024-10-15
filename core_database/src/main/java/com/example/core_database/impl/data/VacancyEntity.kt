package com.example.core_database.impl.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.core.data.model.AddressResponse
import com.example.core.data.model.ExperienceResponse
import com.example.core.data.model.SalaryResponse
import java.io.Serializable

@Entity(
    tableName = "vacancies"
)
data class VacancyEntity (
    val addressResponse: AddressResponse,
    val appliedNumber: Int,
    val company: String,
    val description: String,
    val experience: ExperienceResponse,
    @PrimaryKey(autoGenerate = false) val id: String,
    val isFavorite: Boolean,
    val lookingNumber: Int,
    val publishedDate: String,
    val questions: List<String>,
    val responsibilities: String,
    val salary: SalaryResponse,
    val schedules: String,
    val title: String): Serializable


