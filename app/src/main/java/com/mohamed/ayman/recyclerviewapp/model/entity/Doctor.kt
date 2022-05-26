package com.mohamed.ayman.recyclerviewapp.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Doctor_table")
data class Doctor(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val image: Int,
    val name: String,
    val location: String,
    val time: String
)


