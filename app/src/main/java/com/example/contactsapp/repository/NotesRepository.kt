package com.example.contactsapp.repository

import androidx.lifecycle.LiveData
import com.example.contactsapp.ContactsApp
import com.example.contactsapp.database.ContactsDatabase
import com.example.contactsapp.models.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NotesRepository {
   var database = ContactsDatabase.getDatabase(ContactsApp.appContext)

    suspend fun saveNotes(note: Note){
        withContext(Dispatchers.IO){
            database.notesDao().insertNote(note)
        }
    }
    fun getAllNotes():LiveData<List<Note>>{
        return database.notesDao().getAllNotes()
    }
    fun getNoteBy(noteid:Int):LiveData<Note>{
        return database.notesDao().getNoteById(noteid)
    }
}