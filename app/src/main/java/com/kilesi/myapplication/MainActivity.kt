package com.kilesi.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonClicks()
    }

    private fun buttonClicks() {
        btnSubmit.setOnClickListener {
            submitUserData()
        }

        btnShareToExternalApps.setOnClickListener {
            shareExternally()
        }

        btnShowHobbies.setOnClickListener {
            showHobbies()
        }
    }

    private fun submitUserData() {
        val name = etName.text.toString()
        val id = etId.text.toString()
        val salary = etSalary.text.toString()
        val intent = Intent(this.applicationContext, UserDetailsActivity::class.java)
        intent.putExtra("Name", name)
        intent.putExtra("ID", id)
        intent.putExtra("Salary", salary)
        val message = "User data submitted successfully!"
        showToast(message)
       // Toast.makeText(this, "User data submitted successfully!", Toast.LENGTH_LONG).show()
        startActivity(intent)
    }

    private fun shareExternally() {
        val name = etName.text.toString()
        val intent = Intent()
        intent.action = Intent.ACTION_SEND
        intent.putExtra(Intent.EXTRA_TEXT, name)
        intent.type = "text/plain"
        startActivity(Intent.createChooser(intent, "Share to"))
    }

    private fun showHobbies() {
        startActivity(Intent(this, HobbiesActivity::class.java))
    }
}