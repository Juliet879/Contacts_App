package com.example.contactsapp.models

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contacts")

data class Contact(
    @PrimaryKey(autoGenerate = true) @NonNull var id:Int,
    var name :String,
    var phone :String,
    var email :String,
    var imageUrl:String?
)
