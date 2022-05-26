package com.mohamed.ayman.recyclerviewapp.model.local

import androidx.room.*
import com.mohamed.ayman.recyclerviewapp.model.entity.Doctor
import kotlinx.coroutines.selects.select

@Dao
interface DoctorDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addOrUpdateDoctor(doctor: Doctor)

    @Delete
    suspend fun deleteDoctor(doctor: Doctor)

    @Query("select * from doctor_table ")
    suspend fun getAllDoctors(): List<Doctor>
}