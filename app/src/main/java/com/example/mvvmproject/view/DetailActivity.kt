package com.example.mvvmproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.mvvmproject.R
import com.example.mvvmproject.base.DetailViewModelFactory
import com.example.mvvmproject.base.SecondViewModelFactory
import com.example.mvvmproject.network.api.ApiHelper
import com.example.mvvmproject.network.api.DetailHelper
import com.example.mvvmproject.network.api.RetrofitBuilder
import com.example.mvvmproject.util.Status
import com.example.mvvmproject.viewmodel.DetailViewModel
import com.example.mvvmproject.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var viewModel: DetailViewModel

    companion object {
        const val REPO = "repo"
        const val OWNER = "owner"
        const val AVATAR_URL = "avatar_url"
    }

    private val repo: String by lazy { intent.getStringExtra(REPO) }
    private val owner: String by lazy { intent.getStringExtra(OWNER) }
    private val avatarurl: String by lazy { intent.getStringExtra(AVATAR_URL) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setupViewModel()
        setupObservers()

        if (intent != null) {
            nameDetail.text = "${owner}/"
            repoDetail.text = repo
            Glide.with(this).load(avatarurl)
                .override(1024)
                .error(R.mipmap.ic_launcher)
                .into(imgDetail)
        }

        BackMain.setOnClickListener { finish() }
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProviders.of(
            this,
            SecondViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(MainViewModel::class.java)

        viewModel = ViewModelProviders.of(
            this,
            DetailViewModelFactory(DetailHelper(RetrofitBuilder.detailService))
        ).get(DetailViewModel::class.java)
    }

    private fun setupObservers() {
        mainViewModel.getRepo(owner, repo).observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        progressBar.visibility = View.GONE
                        resource.data?.let { item ->

                            numStars.text = "${item.stargazersCount} stars"
                            descriptionName.text = item.description

                            if (item.language == null) {
                                languageName.setText(R.string.noResponse)
                            } else {
                                languageName.text = item.language
                            }
                        }
                    }
                    Status.ERROR -> {

                    }
                    Status.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                    }
                }
            }
        })

        viewModel.getDetail(owner).observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        progressBar.visibility = View.GONE
                        resource.data?.let { user ->
                            followerNum.text = user.followers.toString()
                            followingNum.text = user.following.toString()
                        }
                    }
                    Status.ERROR -> {
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                        Log.v("@@@@@@@@@@", it.message)
                    }
                    Status.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                    }
                }
            }
        })
    }
}
