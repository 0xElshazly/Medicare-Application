package com.mohamed.ayman.recyclerviewapp.model.local

import com.mohamed.ayman.recyclerviewapp.model.entity.Doctor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalRepositoryImp(private val dp:DoctorDatabase):LocalRepository {
    override suspend fun addOrUpdateDoctor(doctor: Doctor) = withContext(Dispatchers.IO){
        dp.doctorDAO().addOrUpdateDoctor(doctor)
    }

    override suspend fun deleteDoctor(doctor: Doctor) = withContext(Dispatchers.IO){
        dp.doctorDAO().deleteDoctor(doctor)
    }

    override suspend fun getAllDoctors(): List<Doctor> = withContext(Dispatchers.IO){
        dp.doctorDAO().getAllDoctors()
    }


}