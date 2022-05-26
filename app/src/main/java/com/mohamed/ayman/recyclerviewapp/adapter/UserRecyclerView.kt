package com.mohamed.ayman.recyclerviewapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mohamed.ayman.recyclerviewapp.R
import com.mohamed.ayman.recyclerviewapp.model.entity.Category

class UserRecyclerView : RecyclerView.Adapter<UserRecyclerView.UserViewHolder>() {

    var userList: List<Category> = emptyList()
    var onListItemClick: OnListItemClick? = null

    fun setList(userList: List<Category>) {
        this.userList = userList
        notifyDataSetChanged()
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var userimage: ImageView = itemView.findViewById(R.id.user_image_item)
        //var username: TextView = itemView.findViewById(R.id.username_item_text)
        var message: TextView = itemView.findViewById(R.id.message_item_text)

        fun bind(user: Category) {
            userimage.setImageResource(user.imageId)
          //  username.text = user.name
            message.text = user.message

            itemView.setOnClickListener{
                onListItemClick?.onItemClick(user)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        var view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        var user: Category = userList.get(position)
        holder.bind(user)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

}