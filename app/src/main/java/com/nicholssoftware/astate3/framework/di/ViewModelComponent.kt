package com.nicholssoftware.astate3.framework.di

import com.nicholssoftware.astate3.framework.viewmodels.AddContactViewModel
import com.nicholssoftware.astate3.framework.viewmodels.ContactsViewModel
import dagger.Component

@Component(modules = [ApplicationModule::class, RepositoryModule::class, UseCasesModule::class])
interface ViewModelComponent {
    fun inject(contactsViewModel: ContactsViewModel)
    fun inject(addContactViewModel: AddContactViewModel)
}