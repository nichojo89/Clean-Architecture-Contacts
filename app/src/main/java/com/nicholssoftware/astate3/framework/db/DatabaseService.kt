package com.nicholssoftware.astate3.framework.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nicholssoftware.astate3.framework.db.dao.ContactDAO
import com.nicholssoftware.astate3.framework.db.entities.ContactEntity

@Database(entities = [ContactEntity::class], version = 2)
abstract class DatabaseService: RoomDatabase() {

    companion object {
        private const val DATABASE_NAME = "contact.db"

        private var instance: DatabaseService? = null

        private fun create(context: Context): DatabaseService =
            Room.databaseBuilder(context, DatabaseService::class.java,
                DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()


        fun getInstance(context: Context): DatabaseService =
            (instance ?: create(context)).also { instance = it }
    }

    abstract fun contactDao(): ContactDAO
}