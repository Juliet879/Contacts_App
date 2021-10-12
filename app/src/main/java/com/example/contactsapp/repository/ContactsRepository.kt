package com.example.contactsapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.contactsapp.ContactsApp
import com.example.contactsapp.database.ContactDao
import com.example.contactsapp.database.ContactsDatabase
import com.example.contactsapp.models.Contact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ContactsRepository  @Inject constructor(var contactDao: ContactDao) {
//    val database = ContactsDatabase.getDatabase(ContactsApp.appContext)
//    To switch functions from the main
//    Livedata in asynchronous you cannot use room database in the main thread so you have to create a new coroutine
    suspend fun saveContact(contact: Contact) {
        withContext(Dispatchers.IO) {
            contactDao.insertContact(contact)
//            database.getContactDao().insertContact(contact)
        }
    }
    fun getAllContacts(): LiveData<List<Contact>> {
        return contactDao.getAllContacts()
    }
    fun getContactById(contactId: Int): LiveData<Contact> {
        return contactDao.getContactById(contactId)
    }
}