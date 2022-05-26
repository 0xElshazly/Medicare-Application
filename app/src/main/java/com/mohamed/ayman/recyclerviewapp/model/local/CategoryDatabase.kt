package com.mohamed.ayman.recyclerviewapp.model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mohamed.ayman.recyclerviewapp.model.entity.Category
import com.mohamed.ayman.recyclerviewapp.model.entity.Doctor

private const val DATABASE_NAME = "category_database"

@Database(entities = [Category::class], version = 1, exportSchema = false)
abstract class CategoryDatabase : RoomDatabase() {

    abstract fun categoryDAO(): CategoryDAO

    companion object {

        @Volatile
        private var instance: CategoryDatabase? = null

        fun getInstance(context: Context): CategoryDatabase {
            return instance ?: synchronized(Any()) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): CategoryDatabase {
            return Room.databaseBuilder(
                context.applicationContext, CategoryDatabase::class.java,
                DATABASE_NAME
            ).build()
        }
    }
}