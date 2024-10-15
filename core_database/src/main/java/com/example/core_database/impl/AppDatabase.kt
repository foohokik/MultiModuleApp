package com.example.core_database.impl

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.core_database.domain.VacancyDao
import com.example.core_database.impl.data.OfferEntity
import com.example.core_database.impl.data.VacancyEntity
import com.example.core_database.impl.typeconverters.AddressConverter
import com.example.core_database.impl.typeconverters.ExperienceConverter
import com.example.core_database.impl.typeconverters.QuestionsConverter
import com.example.core_database.impl.typeconverters.SalaryConverter

@Database(
    version = 1,
    entities = [
        VacancyEntity::class,
        OfferEntity::class
    ],   exportSchema = false
)
@TypeConverters(
    AddressConverter::class,
    QuestionsConverter::class,
    SalaryConverter::class,
    ExperienceConverter::class
)

abstract class AppDatabase : RoomDatabase() {
    abstract val vacancyDao: VacancyDao
}