package com.example.core_database.domain

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.core_database.impl.data.OfferEntity
import com.example.core_database.impl.data.VacancyEntity

@Dao
interface VacancyDao {

    @Query("SELECT * FROM vacancies")
    suspend fun getAllVacancies(): List<VacancyEntity>

    @Query("SELECT * FROM vacancies WHERE isFavorite = 1")
    suspend fun getAllFavoriteVacancies(): List<VacancyEntity>

    @Query("UPDATE vacancies SET isFavorite = :isFavorite WHERE id = :id" )
    suspend fun updateVacancyIsFavorite(isFavorite: Boolean, id: String)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVacancy(vacancyEntity: VacancyEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVacancies(vacancies: List<VacancyEntity>)

    @Query("SELECT * FROM vacancies WHERE id = :id")
    suspend fun getVacancyById (id: String): VacancyEntity

    @Query("DELETE from vacancies WHERE id IN (:id)")
    suspend fun deleteVacancy(id: String)

    @Query("SELECT * FROM offers")
    suspend fun getAllOffers(): List<OfferEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOffers(offers: List<OfferEntity>)

}