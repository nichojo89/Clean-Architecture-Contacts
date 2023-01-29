package com.nicholssoftware.core.repository

import com.nicholssoftware.core.data.Contact

class ContactsRepository(private val contactsDataSource: ContactsDataSource) {
    suspend fun AddContact(contact: Contact) = contactsDataSource.add(contact)
    suspend fun RemoveContact(contact: Contact) = contactsDataSource.remove(contact)
    suspend fun GetContact(id: Long) = contactsDataSource.get(id)
    suspend fun GetAllContacts() = contactsDataSource.getAll()
}