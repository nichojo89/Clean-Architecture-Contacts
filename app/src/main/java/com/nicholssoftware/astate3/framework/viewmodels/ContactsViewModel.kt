package com.nicholssoftware.astate3.framework.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.nicholssoftware.astate3.framework.UseCases
import com.nicholssoftware.astate3.framework.di.ApplicationModule
import com.nicholssoftware.astate3.framework.di.DaggerViewModelComponent
import com.nicholssoftware.core.data.Contact
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ContactsViewModel(application: Application): AndroidViewModel(application) {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    var contacts = MutableLiveData<List<Contact>>()

    @Inject
    lateinit var useCases:UseCases

    init {
        DaggerViewModelComponent.builder()
            .applicationModule(ApplicationModule(getApplication()))
            .build()
            .inject(this)
    }

    fun getContacts(){
        coroutineScope.launch {
            val c = useCases.getAllContacts()
            contacts.postValue(c)
        }
    }
}