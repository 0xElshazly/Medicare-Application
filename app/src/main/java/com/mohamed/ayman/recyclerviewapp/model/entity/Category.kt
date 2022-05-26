package com.mohamed.ayman.recyclerviewapp.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category_table")
data class Category(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo(name="category_name")
    var name: String,
    var message: String,
    var imageId: Int
)


