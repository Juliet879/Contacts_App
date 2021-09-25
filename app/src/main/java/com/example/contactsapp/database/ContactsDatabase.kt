package com.example.contactsapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.contactsapp.models.Contact
import com.example.contactsapp.models.Note


@Database(entities = arrayOf(Contact::class, Note::class),version = 1)
abstract class ContactsDatabase:RoomDatabase() {
    abstract fun contactDao(): ContactDao

    abstract fun notesDao(): NotesDao

    companion object {
        private var database: ContactsDatabase? = null

        fun getDatabase(context:Context): ContactsDatabase {
            if (database == null){
                database = Room.databaseBuilder(context, ContactsDatabase::class.java,"contactsDb")
                    .fallbackToDestructiveMigration().build()
            }
         return database as ContactsDatabase
        }
    }
}