package com.example.contactsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class ViewContactActivity : AppCompatActivity() {
    lateinit var tvNameView:TextView
    lateinit var tvPhoneView:TextView
    lateinit var tvEmailView:TextView
    lateinit var imgView :ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_contact)

        tvNameView = findViewById(R.id.tvNameView)
        tvPhoneView = findViewById(R.id.tvPhoneView)
        tvEmailView = findViewById(R.id.tvEmailView)
        imgView = findViewById(R.id.imgView)

        val intentName = intent.getStringExtra("name")
        val intentPhone = intent.getStringExtra("phone")
        val emailIntent = intent.getStringExtra("email")
        var imageIntent = intent.getStringExtra("image").toString()
        Picasso.get()
            .load(imageIntent)
            .into(imgView)

        tvNameView.text = intentName
        tvPhoneView.text = intentPhone
        tvEmailView.text = emailIntent


    }
}