package com.example.mvvmproject.ui.base.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvmproject.R
import com.example.mvvmproject.ui.base.main.view.adapter.VPAdapter
import kotlinx.android.synthetic.main.activity_page.*

class PageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page)

        val vpAdapter =
            VPAdapter(supportFragmentManager)

        viewpager.adapter = vpAdapter

    }
}
