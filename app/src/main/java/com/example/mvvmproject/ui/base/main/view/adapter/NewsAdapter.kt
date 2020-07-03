package com.example.mvvmproject.ui.base.main.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmproject.databinding.NewItemViewBinding
import com.example.mvvmproject.ui.base.main.view.viewmodel.CoronaViewModel

class NewsAdapter(viewModel: CoronaViewModel) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private val viewModel = viewModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        val binding: NewItemViewBinding =
            NewItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int  = viewModel.getNewsItem().size

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
        holder.bind(viewModel, position)
    }

    inner class ViewHolder(binding: NewItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        val binding = binding

        fun bind(viewModel: CoronaViewModel, position: Int) {
            binding.pos = position
            binding.coronaViewModel = viewModel
            binding.executePendingBindings()
        }
    }
}