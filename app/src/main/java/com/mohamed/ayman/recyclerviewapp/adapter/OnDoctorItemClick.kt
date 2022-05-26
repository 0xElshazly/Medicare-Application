package com.mohamed.ayman.recyclerviewapp.adapter


import com.mohamed.ayman.recyclerviewapp.model.entity.Doctor

interface OnDoctorItemClick {
    fun onItemClick(user: Doctor)
}