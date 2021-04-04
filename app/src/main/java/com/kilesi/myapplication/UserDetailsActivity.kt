package com.kilesi.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_user_details.*

class UserDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)
        receiveUserData()
    }

    private fun receiveUserData() {
        val bundle: Bundle? = intent.extras
        val name = bundle?.getString("Name")
        val id = bundle?.getString("ID")
        val salary = bundle?.getString("Salary")
        tvUserName.text = name
        tvUserId.text = id
        tvUserSalary.text = salary
        Toast.makeText(this, "Data received!!", Toast.LENGTH_LONG).show()
    }
}