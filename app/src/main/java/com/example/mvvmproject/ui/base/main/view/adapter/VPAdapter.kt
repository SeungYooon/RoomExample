package com.example.mvvmproject.ui.base.main.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.mvvmproject.ui.base.main.view.FragmentSearch

class VPAdapter(fm: FragmentManager?) :
    FragmentPagerAdapter(fm!!) {

    private val items: ArrayList<Fragment> = ArrayList()

    override fun getItem(position: Int): Fragment = items[position]

    override fun getCount(): Int = items.size

    init {
        items.add(FragmentSearch())
//        items.add(FragmentBoard())
//        items.add(FragmentMap())
//        items.add(FragmentTreat())
    }
}