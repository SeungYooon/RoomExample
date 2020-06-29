package com.example.mvvmproject.util.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmproject.R
import com.example.mvvmproject.model.Museum
import kotlinx.android.synthetic.main.row_museum.view.*

class MuseumAdapter(private var museums: List<Museum>) :
    RecyclerView.Adapter<MuseumAdapter.MViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewtype: Int): MViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_museum, parent, false)
        return MViewHolder(view)
    }

    override fun onBindViewHolder(holder: MViewHolder, position: Int) {
        holder.bind(museums[position])
    }

    override fun getItemCount(): Int = museums.size

    fun update(data: List<Museum>) {
        museums = data
        notifyDataSetChanged()
    }

    class MViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view: View = v

        fun bind(museum: Museum) {
            view.textFullName.text = museum.name

            Glide.with(view.context).load(museum.photo).override(1024).error(R.mipmap.ic_launcher)
                .into(view.imageView)
        }
    }
}