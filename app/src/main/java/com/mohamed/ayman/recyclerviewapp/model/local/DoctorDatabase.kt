package com.mohamed.ayman.recyclerviewapp.model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mohamed.ayman.recyclerviewapp.model.entity.Doctor

private const val DATABASE_NAME = "doctor_database"

@Database(entities = [Doctor::class], version = 1, exportSchema = false)
abstract class DoctorDatabase : RoomDatabase() {
    abstract fun doctorDAO(): DoctorDAO

    companion object {
        @Volatile
        private var instance: DoctorDatabase? = null

        //construct database  (return if exist else lock code until created)
        fun getInstance(context: Context): DoctorDatabase {
            return instance ?: synchronized(Any()) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): DoctorDatabase {
            return Room.databaseBuilder(
                context.applicationContext, DoctorDatabase::class.java,
                "doctor_database"
            ).build()
        }
    }
}