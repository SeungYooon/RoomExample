package com.example.mvvmproject.util.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmproject.R
import com.example.mvvmproject.dto.CompanyItem
import kotlinx.android.synthetic.main.item_company.view.*

class CompanyAdapter(
    private val ItemClick: (CompanyItem) -> Unit,
    private val ItemLongClick: (CompanyItem) -> Unit
) :
    RecyclerView.Adapter<CompanyAdapter.ViewHolder>() {

    private var companyItems: List<CompanyItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_company, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = companyItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = companyItems[position]

        holder.apply {
            bind(item)
            itemView.tag = item
        }
        //  holder.bind(companyItems[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var view: View = itemView

        fun bind(companyItem: CompanyItem) {
            view.companyInitial.text = companyItem.initial.toString()
            view.company_location.text = companyItem.companyLocation
            view.company_name.text = companyItem.compnayName

            view.setOnClickListener {
                ItemClick(companyItem)
            }
            view.setOnLongClickListener {
                ItemLongClick(companyItem)
                true
            }
        }
    }

    fun setContacts(companyItems: List<CompanyItem>) {
        this.companyItems = companyItems
        notifyDataSetChanged()
    }
}