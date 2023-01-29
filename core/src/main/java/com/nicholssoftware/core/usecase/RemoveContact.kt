package com.nicholssoftware.core.usecase

import com.nicholssoftware.core.data.Contact
import com.nicholssoftware.core.repository.ContactsRepository

class RemoveContact(private val contactsRepository: ContactsRepository) {
    suspend fun invoke(contact: Contact) = contactsRepository.RemoveContact(contact)
}