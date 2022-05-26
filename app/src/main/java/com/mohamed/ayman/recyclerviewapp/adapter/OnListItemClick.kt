package com.mohamed.ayman.recyclerviewapp.adapter

import com.mohamed.ayman.recyclerviewapp.model.entity.Category


// interface implement func on it only
// cant take an object from interface
interface OnListItemClick {
    fun onItemClick(user: Category)
}