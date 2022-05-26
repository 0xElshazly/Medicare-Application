package com.mohamed.ayman.recyclerviewapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mohamed.ayman.recyclerviewapp.R
import com.mohamed.ayman.recyclerviewapp.model.entity.Doctor


class DoctorRecyclerView : RecyclerView.Adapter<DoctorRecyclerView.UserViewHolder>() {

    var userList: List<Doctor> = emptyList()
    var onListItemClick: OnDoctorItemClick? = null

    // fun to put item in the list
    fun setList(userList: List<Doctor>) {
        this.userList = userList
        // when add new item in array list notifay to all GUI
        notifyDataSetChanged()
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var userimage: ImageView = itemView.findViewById(R.id.doctor_image)
        var username: TextView = itemView.findViewById(R.id.doctorname_text)
        var time: TextView = itemView.findViewById(R.id.doctortime_text)
        var location: TextView = itemView.findViewById(R.id.doctorlocation_text)
        fun bind(doc: Doctor) {
            userimage.setImageResource(doc.image)
            username.text = doc.name
            time.text = doc.time
            location.text = doc.location

            itemView.setOnClickListener {
                onListItemClick?.onItemClick(doc)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        var view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.doctor_item_view, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        var user: Doctor = userList.get(position)
        holder.bind(user)
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}