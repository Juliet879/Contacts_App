package com.example.contactsapp.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.contactsapp.models.Contact
import com.example.contactsapp.models.Note

@Dao
interface NotesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note: Note)

    @Query("SELECT * FROM Notes")
    fun getAllNotes(): LiveData<List<Note>>

    @Query("SELECT * FROM Notes WHERE id = :noteId")
    fun getNoteById(noteId:Int): LiveData<Note>

    @Delete
    fun deleteNote(note:Note)
}