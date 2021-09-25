package com.example.contactsapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contactsapp.ContactsRecyclerViewAdapter
import com.example.contactsapp.viewmodels.ContactsViewModel
import com.example.contactsapp.R
import com.example.contactsapp.databinding.ActivityContactsBinding
import com.example.contactsapp.models.Contact

class ContactsActivity : AppCompatActivity() {
    lateinit var binding:ActivityContactsBinding
    val contactsViewModel: ContactsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        contactsViewModel.contactsLiveData.observe(this,{contacts ->
            display(contacts)
        })
        binding.btnAddButton.setOnClickListener{
            startActivity(Intent(this,AddContactActivity::class.java))
        }
    }

    fun display(contactList:List<Contact>){
        var contactRecyclerView = findViewById<RecyclerView>(R.id.rvContacts)
        var contactsAdapter = ContactsRecyclerViewAdapter(contactList,baseContext)
        contactRecyclerView.layoutManager = LinearLayoutManager(baseContext)
        contactRecyclerView.adapter = contactsAdapter
    }
}