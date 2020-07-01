package com.example.mvvmproject.ui.base.main.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmproject.R
import com.example.mvvmproject.data.model.User
import kotlinx.android.synthetic.main.user_item.view.*

class UserAdapter(private val users: ArrayList<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: UserAdapter.UserViewHolder, position: Int) {
        holder.bind(users[position])
    }


    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(user: User) {
            itemView.textViewUserName.text = user.name
            itemView.textViewUserEmail.text = user.eamil
            Glide.with(itemView.imageViewAvatar.context).load(user.avatar).override(1024)
                .error(R.mipmap.ic_launcher)
                .into(itemView.imageViewAvatar)
        }
    }

    fun addData(list: List<User>) {
        users.addAll(list)
        notifyDataSetChanged()
    }
}