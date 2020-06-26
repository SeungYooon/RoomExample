package com.example.mvvmproject.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmproject.*
import com.example.mvvmproject.base.CompanyViewModel
import com.example.mvvmproject.dto.CompanyItem
import com.example.mvvmproject.util.adapter.CompanyAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var companyViewModel: CompanyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mAdapter = CompanyAdapter({ companyItem ->
            val intent = Intent(this, AddCompanyActivity::class.java)
            intent.putExtra(AddCompanyActivity.COMPANY_NAME, companyItem.compnayName)
            intent.putExtra(AddCompanyActivity.COMPANY_LOCATION, companyItem.companyLocation)
            intent.putExtra(AddCompanyActivity.COMPANY_INITIAL, companyItem.id)
            startActivity(intent)
        }, { companyItem ->
            deleteDialog(companyItem)
        })
        recycleView.adapter = mAdapter
        recycleView.setHasFixedSize(true)

        companyViewModel = ViewModelProviders.of(this).get(CompanyViewModel::class.java)
        companyViewModel.getAll().observe(this, Observer<List<CompanyItem>> { company ->
            // Udpate View
            mAdapter.setContacts(company)
        })

        fab.setOnClickListener {
            val intent = Intent(this, AddCompanyActivity::class.java)
            startActivity(intent)
        }
    }

    private fun deleteDialog(companyItem: CompanyItem) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("해당 아이템을 삭제할까요?")
            .setNegativeButton("NO") { _, _ -> }
            .setPositiveButton("YES") { _, _ ->
                companyViewModel.delete(companyItem)
            }
        builder.show()
    }
}
