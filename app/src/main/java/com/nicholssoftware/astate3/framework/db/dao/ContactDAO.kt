package com.nicholssoftware.astate3.framework.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.nicholssoftware.astate3.framework.db.entities.ContactEntity

@Dao
interface ContactDAO {
    @Insert(onConflict = REPLACE)
    suspend fun addContactEntity(contactEntity: ContactEntity)

    @Query("SELECT * FROM contact WHERE id = :id")
    suspend fun getContactEntity(id: Long): ContactEntity?

    @Query("SELECT * FROM contact")
    suspend fun getAllContactEntities(): List<ContactEntity>

    @Delete
    suspend fun deleteContactEntity(contactEntity: ContactEntity)
}