package com.example.contactsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var navigate = findViewById<Button>(R.id.btnViewContacts)

        navigate.setOnClickListener {
            var intent = Intent(baseContext,ContactsActivity::class.java)
            startActivity(intent)
        }
    }
}