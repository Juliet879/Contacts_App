package com.example.contactsapp.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.contactsapp.models.Contact


@Dao
interface ContactDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContact(contact: Contact)

    @Query("SELECT * FROM Contacts")
    fun getAllContacts():LiveData<List<Contact>>

    @Query("SELECT * FROM Contacts WHERE id = :contactId")
    fun getContactById(contactId:Int):LiveData<Contact>

    @Delete
    fun deleteContact(contact:Contact)
}