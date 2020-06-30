package com.example.mvvmproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmproject.dto.CompanyItem
import com.example.mvvmproject.viewmodel.CompanyViewModel
import com.example.mvvmproject.R
import kotlinx.android.synthetic.main.activity_add.*

class AddCompanyActivity : AppCompatActivity() {

    private lateinit var companyViewModel: CompanyViewModel
    private var id: Long? = null

    companion object {
        const val COMPANY_NAME = "company_name"
        const val COMPANY_LOCATION = "company_location"
        const val COMPANY_INITIAL = "company_initial"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        companyViewModel = ViewModelProviders.of(this).get(CompanyViewModel::class.java)

        if (intent != null && intent.hasExtra(COMPANY_NAME) && intent.hasExtra(
                COMPANY_LOCATION
            )
            && intent.hasExtra(COMPANY_INITIAL)
        ) {
            edit_companyName.setText(intent.getStringExtra(COMPANY_NAME))
            edit_companyLocation.setText(intent.getStringExtra(COMPANY_LOCATION))
            id = intent.getLongExtra(COMPANY_INITIAL, -1)
        }

        btnAdd.setOnClickListener {
            val cName = edit_companyName.text.toString().trim()
            val cLocation = edit_companyLocation.text.toString()

            if (cName.isEmpty() || cLocation.isEmpty()) {
                Toast.makeText(this, "회사명과 위치를 입력해주세요!", Toast.LENGTH_SHORT).show()
            } else {
                val initial = cName[0].toUpperCase()
                val contact =
                    CompanyItem(
                        id,
                        cName,
                        cLocation,
                        initial
                    )
                companyViewModel.insert(contact)
                finish()
            }
        }

    }
}
