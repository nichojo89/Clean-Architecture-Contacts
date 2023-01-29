package com.nicholssoftware.core.usecase

import com.nicholssoftware.core.data.Contact
import com.nicholssoftware.core.repository.ContactsRepository

class GetAllContacts(private val contactsRepository: ContactsRepository) {
    suspend operator fun invoke() = contactsRepository.GetAllContacts()
}