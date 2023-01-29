package com.nicholssoftware.astate3.framework.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.nicholssoftware.astate3.framework.UseCases
import com.nicholssoftware.astate3.framework.di.ApplicationModule
import com.nicholssoftware.astate3.framework.di.DaggerViewModelComponent
import com.nicholssoftware.core.data.Contact
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddContactViewModel(application: Application) : AndroidViewModel(application) {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    @Inject
    lateinit var useCases: UseCases

    init {
        DaggerViewModelComponent.builder()
            .applicationModule(ApplicationModule(getApplication()))
            .build()
            .inject(this)
    }

    fun addContact(contact: Contact){
        coroutineScope.launch {
            useCases.addContact(contact)
            //pop stack
        }
    }
}