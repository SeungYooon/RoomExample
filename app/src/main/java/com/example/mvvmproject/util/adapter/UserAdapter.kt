package com.example.mvvmproject.util.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmproject.R
import com.example.mvvmproject.model.Item
import com.example.mvvmproject.model.User
import com.example.mvvmproject.view.DetailActivity
import kotlinx.android.synthetic.main.item_layout.view.*

class UserAdapter(private var users: ArrayList<Item>) :
    RecyclerView.Adapter<UserAdapter.DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return DataViewHolder(v)
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val user = users[position]

        holder.bind(users[position])

        holder.itemView.setOnClickListener {
            Toast.makeText(it.context, "mvvm success :${user.repositoryName}", Toast.LENGTH_SHORT)
                .show()

            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.AVATAR_URL, user.owner.avatarUrl)
            intent.putExtra(DetailActivity.OWNER, user.owner.ownerName)
            intent.putExtra(DetailActivity.REPO, user.repositoryName)

            it.context.startActivity(intent)
        }
    }

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(user: Item) {
            itemView.apply {
                txtName.text = "${user.owner.ownerName}/"
                txtRepo.text = user.repositoryName

                if (user.language == null) {
                    txtLangguage.setText(R.string.noResponse)
                } else {
                    txtLangguage.text = user.language
                }
                Glide.with(imgAvatar.context).load(user.owner.avatarUrl).override(1024)
                    .error(R.mipmap.ic_launcher)
                    .into(imgAvatar)
            }
        }
    }

    fun addUsers(users: ArrayList<Item>) {
        this.users.apply {
            clear()
            addAll(users)
            notifyDataSetChanged()
        }
    }

    fun update(data:ArrayList<Item>) {
        users = data
        notifyDataSetChanged()
    }
}