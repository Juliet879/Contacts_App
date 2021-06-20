package com.example.contactsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ContactsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)
        display()
    }
    fun display(){
        var contactRecyclerView = findViewById<RecyclerView>(R.id.rvContacts)

        var contactsList = listOf(
            Contacts("Rackel Otieno","0706743954","rackeliotis@gmil.com"),
            Contacts("Michael Omache","07548656","rackeliotis@gmil.com"),
            Contacts("Faith Moraa","074786788","rackeliotis@gmil.com"),
            Contacts("Gladys Mose","0700987364","rackeliotis@gmil.com"),
            Contacts("Wuanita Wanjiku","079486364","waniwanjiku@gmil.com"),
            Contacts("Sarah Sindet","0706743954","sindet2002@gmil.com"),
            Contacts("Wato Woto","0785757854","erinawato@gmil.com"),
            Contacts("Sylvia Amondi","079845743","amondisly@gmil.com"),
            Contacts("Peter Marocho","0789538946","pmarocho@gmil.com"),
            Contacts("Lynne Hasset","0706743954","lyne254h@gmil.com"),
            Contacts("Belinda Omwami","078043662","lindamwas@gmil.com"),
            Contacts("Shadya Obuya ","07923854524","shadyaobuyagard@gmil.com"),

            )
        var contactsAdapter = ContactsRecyclerViewAdapter(contactsList)
        contactRecyclerView.layoutManager = LinearLayoutManager(baseContext)
        contactRecyclerView.adapter = contactsAdapter
    }
}