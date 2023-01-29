package com.nicholssoftware.astate3.framework.di

import com.nicholssoftware.astate3.framework.UseCases
import com.nicholssoftware.core.repository.ContactsRepository
import com.nicholssoftware.core.usecase.AddContact
import com.nicholssoftware.core.usecase.GetAllContacts
import com.nicholssoftware.core.usecase.GetContact
import com.nicholssoftware.core.usecase.RemoveContact
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {
    @Provides
    fun getUseCases(contactsRepository: ContactsRepository) =
        UseCases(
            AddContact(contactsRepository),
            GetContact(contactsRepository),
            GetAllContacts(contactsRepository),
            RemoveContact(contactsRepository)
        )
}