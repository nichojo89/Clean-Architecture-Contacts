package com.nicholssoftware.core.repository

import com.nicholssoftware.core.data.Contact

interface ContactsDataSource {
    suspend fun get(id:Long): Contact?
    suspend fun getAll(): List<Contact>
    suspend fun add(contact:Contact)
    suspend fun remove(contact: Contact)
}