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
            Contacts("Rackel Otieno","0706743954","rackeliotis@gmil.com","https://www.wonderslist.com/wp-content/uploads/2016/10/Brad-Pitt-Most-Handsome-Men.jpg"),
            Contacts("Michael Omache","07548656","rackeliotis@gmil.com","https://thumbs.dreamstime.com/b/side-portrait-handsome-young-black-man-leaning-wall-outside-close-up-92169422.jpg"),
            Contacts("Faith Moraa","074786788","rackeliotis@gmil.com","https://i.pinimg.com/originals/73/7e/4a/737e4a906a9e9a5a819f1946ebd30301.jpg"),
            Contacts("Gladys Mose","0700987364","rackeliotis@gmil.com","https://www.toptrendsguide.com/wp-content/uploads/2020/07/Rihanna.jpg"),
            Contacts("Wuanita Wanjiku","079486364","waniwanjiku@gmil.com","https://eu-west-1-classic105.s3.amazonaws.com/wp-content/uploads/2016/05/Lupita-Nyongo-Speech-Essence-Black-Women-Hollywood-e1462695037411.jpg"),
            Contacts("Sarah Sindet","0706743954","sindet2002@gmil.com","https://atozhairstyles.com/wp-content/uploads/2018/10/3-Denzel-Washington-683x1024.jpg"),
            Contacts("Wato Woto","0785757854","erinawato@gmil.com","https://i.pinimg.com/236x/d8/d1/17/d8d117a1437bb0a58a82e4b1cf53f163--ebony-women.jpg"),
            Contacts("Sylvia Amondi","079845743","amondisly@gmil.com","https://i.pinimg.com/originals/83/fe/b0/83feb0bfc3f688e7efe5a57a0383f1b8.jpg"),
            Contacts("Peter Marocho","0789538946","pmarocho@gmil.com","https://qph.fs.quoracdn.net/main-qimg-f47c983213a7ef8ddc779ea0e5553b44"),
            Contacts("Lynne Hasset","0706743954","lyne254h@gmil.com","https://i.pinimg.com/474x/ce/85/b5/ce85b5309d2adb4a6160ca7723d98c6e.jpg"),
            Contacts("Shadya Obuya ","07923854524","shadyaobuyagard@gmil.com",null),

            )
        var contactsAdapter = ContactsRecyclerViewAdapter(contactsList,baseContext)
        contactRecyclerView.layoutManager = LinearLayoutManager(baseContext)
        contactRecyclerView.adapter = contactsAdapter
    }
}