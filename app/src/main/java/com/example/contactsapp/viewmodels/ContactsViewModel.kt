package com.example.contactsapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contactsapp.models.Contact
import com.example.contactsapp.repository.ContactsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactsViewModel @Inject constructor(val contactsRepository: ContactsRepository) :ViewModel() {
    lateinit var contactsLiveData: LiveData<List<Contact>>
    lateinit var contactLiveData: LiveData<Contact>

    fun saveContact(contact: Contact) {
        viewModelScope.launch {
            contactsRepository.saveContact(contact)
        }
    }
//The repository returns a live data so we don't have to create a coroutine
    fun getAllContacts(){
       contactsLiveData = contactsRepository.getAllContacts()
    }

    fun getAllContactById(contactId:Int){
        contactLiveData = contactsRepository.getContactById(contactId) as MutableLiveData<Contact>
    }
}