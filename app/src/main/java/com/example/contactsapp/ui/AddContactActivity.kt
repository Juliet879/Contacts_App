package com.example.contactsapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.contactsapp.viewmodels.ContactsViewModel
import com.example.contactsapp.R
import com.example.contactsapp.databinding.ActivityAddContactBinding
import com.example.contactsapp.models.Contact

class AddContactActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddContactBinding
    val contactViewModel : ContactsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddContactBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_add_contact)
    }

    override fun onResume() {
        super.onResume()
        binding.btnAdd.setOnClickListener{
            validateContact()
          }
    }

    fun validateContact() {
        binding.name.error = null
        binding.etPhone.error = null
        binding.etEmail.error = null
        val name = binding.etAddName.text.toString()
        val phone = binding.etPhoneAdd.text.toString()
        val email = binding.etEmailAdd.toString()

        var error = false
        if (name.isEmpty() || name.isBlank()) {
            error = true
            binding.name.error = getString(R.string.name_required)
        }
        if (phone.isEmpty() || name.isBlank()) {
            error = true
            binding.etPhone.error = getString(R.string.phone_required)
        }
        if (email.isEmpty() || name.isBlank()) {
            error = true
            binding.etPhone.error = getString(R.string.email_required)
        }
        if (!error) {
            val contact = Contact(0,name,phone,email,"")
            contactViewModel.saveContact(contact)
            binding.etAddName.setText("")
            binding.etPhoneAdd.setText("")
            binding.etEmailAdd.setText("")
        }
    }
}


