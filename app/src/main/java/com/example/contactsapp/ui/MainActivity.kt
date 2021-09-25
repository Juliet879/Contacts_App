package com.example.contactsapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.contactsapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigate = findViewById<Button>(R.id.btnViewContacts)

        navigate.setOnClickListener {
            val intent = Intent(baseContext, ContactsActivity::class.java)
            startActivity(intent)
        }
    }
}