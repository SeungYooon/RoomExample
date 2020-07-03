package com.example.mvvmproject.ui.base.main.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmproject.R
import com.example.mvvmproject.databinding.FragmentSearchBinding
import com.example.mvvmproject.ui.base.main.view.viewmodel.CoronaViewModel

class FragmentSearch : Fragment() {

    private lateinit var vm: CoronaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentSearchBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false)
        vm = ViewModelProviders.of(this).get(CoronaViewModel::class.java)
        vm.viewInit(binding.fragmentRecycleView)
        vm.getNews()
        vm.uri?.observe(viewLifecycleOwner, Observer { uri ->
            val intent = Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        })

        binding.coronaViewModel = vm
        binding.lifecycleOwner = this
        return binding.root
    }
}
