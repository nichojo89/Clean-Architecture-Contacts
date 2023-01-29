package com.nicholssoftware.astate3.framework

import android.content.Context
import com.nicholssoftware.astate3.framework.db.DatabaseService
import com.nicholssoftware.astate3.framework.db.entities.ContactEntity
import com.nicholssoftware.core.data.Contact
import com.nicholssoftware.core.repository.ContactsDataSource

class RoomContactDataSource(context: Context): ContactsDataSource {
    val contactDao = DatabaseService.getInstance(context).contactDao()
    override suspend fun get(id: Long): Contact? =
        contactDao.getContactEntity(id)?.toContact()

    override suspend fun getAll(): List<Contact> =
        contactDao.getAllContactEntities().map { it.toContact() }

    override suspend fun add(contact: Contact) =
        contactDao.addContactEntity(ContactEntity.fromContact(contact))

    override suspend fun remove(contact: Contact) =
        contactDao.deleteContactEntity(ContactEntity.fromContact(contact))
}