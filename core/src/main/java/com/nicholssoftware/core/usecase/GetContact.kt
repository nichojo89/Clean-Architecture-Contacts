package com.nicholssoftware.core.usecase

import com.nicholssoftware.core.repository.ContactsRepository

class GetContact(private val contactsRepository: ContactsRepository) {
    suspend fun invoke(id:Long) = contactsRepository.GetContact(id)
}