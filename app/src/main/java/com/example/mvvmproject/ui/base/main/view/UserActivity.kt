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
import com.example.mvvmproject.data.api.UserHelper
import com.example.mvvmproject.data.api.UserServiceImpl
import com.example.mvvmproject.data.model.User
import com.example.mvvmproject.ui.base.UserModelFactory
import com.example.mvvmproject.ui.base.main.view.adapter.UserAdapter
import com.example.mvvmproject.ui.base.main.view.viewmodel.UserViewModel
import com.example.mvvmproject.util.Status
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        setupUI()
        setupViewModel()
        setupObserver()
    }

    private fun setupObserver() {
        userViewModel.getUsers().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    it.data?.let { users -> renderList(users) }
                    recyclerUser.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerUser.visibility = View.GONE
                }
                Status.ERROR -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun renderList(users: List<User>) {
        adapter.addData(users)
    }

    private fun setupViewModel() {
        userViewModel = ViewModelProviders.of(
            this, UserModelFactory(UserHelper(UserServiceImpl()))
        ).get(UserViewModel::class.java)
    }

    private fun setupUI() {
        adapter = UserAdapter(arrayListOf())
        recyclerUser.addItemDecoration(
            DividerItemDecoration(
                recyclerUser.context,
                (recyclerUser.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerUser.adapter = adapter
    }
}
