package com.mohamed.ayman.recyclerviewapp.model.local

import com.mohamed.ayman.recyclerviewapp.model.entity.Category
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext



class LocalRepositoryImp2(private val db: CategoryDatabase) : LocalRepository2 {

    override suspend fun getUsers() =
        withContext(Dispatchers.IO) {
            db.categoryDAO().getUsers()
        }


    override suspend fun deleteUser(user: Category) {
        withContext(Dispatchers.IO) {
            db.categoryDAO().deleteUser(user)
        }
    }

    override suspend fun insertOrUpdateUser(user: Category) {
        withContext(Dispatchers.IO) {
            db.categoryDAO().insertOrUpdateUser(user)
        }
    }

    override suspend fun update(user: Category) {
        withContext(Dispatchers.IO) {
            db.categoryDAO().update(user)
        }
    }

}