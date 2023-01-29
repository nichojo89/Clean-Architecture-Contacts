package com.nicholssoftware.astate3.framework

import com.nicholssoftware.core.usecase.AddContact
import com.nicholssoftware.core.usecase.GetAllContacts
import com.nicholssoftware.core.usecase.GetContact
import com.nicholssoftware.core.usecase.RemoveContact

data class UseCases (
    val addContact: AddContact,
    val getContact: GetContact,
    val getAllContacts: GetAllContacts,
    val removeContact: RemoveContact
    )