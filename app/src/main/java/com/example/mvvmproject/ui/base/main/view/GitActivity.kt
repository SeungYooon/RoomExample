package com.example.mvvmproject.ui.base.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmproject.R
import com.example.mvvmproject.ui.base.SecondViewModelFactory
import com.example.mvvmproject.data.api.ApiHelper
import com.example.mvvmproject.data.api.RetrofitBuilder
import com.example.mvvmproject.util.Status
import com.example.mvvmproject.ui.base.main.view.adapter.GitAdapter
import com.example.mvvmproject.ui.base.main.view.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_git.*

class GitActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private var adapter: GitAdapter = GitAdapter(users = ArrayList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_git)

        setupViewModel()
        setupUI()
        setupObservers()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this, SecondViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(MainViewModel::class.java)
    }

    private fun setupUI() {
        rcView.adapter = adapter
        rcView.setHasFixedSize(true)

        rcView.addItemDecoration(
            DividerItemDecoration(
                rcView.context,
                (rcView.layoutManager as LinearLayoutManager).orientation
            )
        )
    }

    private fun setupObservers() {
        imgSearch.setOnClickListener {
            viewModel.getUsers(editSearch.text.toString()).observe(this, Observer {
                it?.let { resource ->
                    when (resource.status) {
                        Status.SUCCESS -> {
                            rcView.visibility = View.VISIBLE
                            pbBar.visibility = View.GONE
                            Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                            resource.data?.let { item -> adapter.addUsers(item.items) }
                        }
                        Status.ERROR -> {
                            rcView.visibility = View.VISIBLE
                            pbBar.visibility = View.GONE
                            Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                        }
                        Status.LOADING -> {
                            pbBar.visibility = View.VISIBLE
                            rcView.visibility = View.GONE
                        }
                    }
                }
            })
        }
    }

    /*private fun retrieveList(users: User) {
        adapter.apply {
            addUsers(users)

        }
    }*/
}
