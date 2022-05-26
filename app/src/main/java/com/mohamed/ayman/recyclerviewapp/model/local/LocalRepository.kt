package com.mohamed.ayman.recyclerviewapp.model.local

import com.mohamed.ayman.recyclerviewapp.model.entity.Doctor

interface LocalRepository {

     suspend fun addOrUpdateDoctor(doctor: Doctor)

     suspend fun deleteDoctor(doctor: Doctor)

     suspend fun getAllDoctors():List<Doctor>



}