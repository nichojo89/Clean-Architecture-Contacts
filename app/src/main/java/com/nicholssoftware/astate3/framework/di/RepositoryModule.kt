package com.nicholssoftware.astate3.framework.di

import android.app.Application
import com.nicholssoftware.astate3.framework.RoomContactDataSource
import com.nicholssoftware.core.repository.ContactsDataSource
import com.nicholssoftware.core.repository.ContactsRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun providesContactsRepository(app: Application) = ContactsRepository(RoomContactDataSource(app))
}