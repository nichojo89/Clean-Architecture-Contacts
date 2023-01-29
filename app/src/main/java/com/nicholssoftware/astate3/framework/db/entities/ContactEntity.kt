package com.nicholssoftware.astate3.framework.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nicholssoftware.core.data.Contact

@Entity(tableName = "contact")
data class ContactEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var firstName: String,
    var lastName: String,
    var phoneNumber: String){
    companion object{
        fun fromContact(contact: Contact) = ContactEntity(contact.id,contact.firstName,contact.lastName,contact.phoneNumber)
    }
    fun toContact() = Contact(firstName,lastName,phoneNumber,id)
}