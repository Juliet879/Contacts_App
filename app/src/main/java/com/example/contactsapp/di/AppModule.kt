package com.example.contactsapp.di

import android.content.Context
import com.example.contactsapp.database.ContactDao
import com.example.contactsapp.database.ContactsDatabase
import com.example.contactsapp.repository.ContactsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext:Context):ContactsDatabase{
        return ContactsDatabase.getDatabase(appContext)
    }

    @Singleton
    @Provides
    fun provideContactDao(database: ContactsDatabase):ContactDao{
        return database.getContactDao()
    }


    @Singleton
    @Provides
    fun provideContactRepository(contactDao: ContactDao):ContactsRepository{
        return ContactsRepository(contactDao)
    }
}