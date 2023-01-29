package com.nicholssoftware.core.usecase

import com.nicholssoftware.core.data.Contact
import com.nicholssoftware.core.repository.ContactsRepository

class AddContact(private val contactsRepository: ContactsRepository) {
    suspend operator fun invoke(contact: Contact) = contactsRepository.AddContact(contact)
}