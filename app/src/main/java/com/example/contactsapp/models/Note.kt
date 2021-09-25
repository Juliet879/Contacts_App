package com.example.contactsapp.models

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes")
data class Note(
    @PrimaryKey(autoGenerate = true) @NonNull var id: Int,
    var date: String,
    var title:String,
    var body:String
)
