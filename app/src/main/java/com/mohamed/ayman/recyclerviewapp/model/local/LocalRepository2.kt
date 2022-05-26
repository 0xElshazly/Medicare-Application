package com.mohamed.ayman.recyclerviewapp.model.local

import com.mohamed.ayman.recyclerviewapp.model.entity.Category

interface LocalRepository2 {
    suspend fun getUsers():List<Category>

    suspend fun deleteUser(user:Category)

    suspend fun insertOrUpdateUser(user: Category)

    suspend fun update(user: Category)
}