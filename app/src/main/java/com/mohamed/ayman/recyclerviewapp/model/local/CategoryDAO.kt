package com.mohamed.ayman.recyclerviewapp.model.local

import androidx.room.*
import com.mohamed.ayman.recyclerviewapp.model.entity.Category


@Dao
interface CategoryDAO {


    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateUser(user: Category)

    @Update
    suspend fun update(user: Category)

    @Delete
    suspend fun deleteUser(user:Category)

    @Query("select * from category_table")
    suspend fun getUsers():List<Category>

}