package com.example.contactsapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contactsapp.models.Note
import com.example.contactsapp.repository.NotesRepository
import kotlinx.coroutines.launch

class NotesViewModel:ViewModel() {
    val notesRepository = NotesRepository()
    lateinit var notesLiveData:LiveData<List<Note>>
    lateinit var noteLiveData:LiveData<Note>

    fun saveNotes(note: Note){
        viewModelScope.launch {
            notesRepository.saveNotes(note)
        }
    }
    fun getAllNotes(){
        notesLiveData = notesRepository.getAllNotes()
    }
    fun getNoteById(noteId:Int){
        noteLiveData = notesRepository.getNoteBy(noteId)
    }
}