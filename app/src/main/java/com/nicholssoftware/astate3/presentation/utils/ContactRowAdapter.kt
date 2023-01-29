package com.nicholssoftware.astate3.presentation.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nicholssoftware.astate3.R
import com.nicholssoftware.core.data.Contact

class ContactRowAdapter(private var userArrayList: ArrayList<Contact>) :
    RecyclerView.Adapter<ContactRowAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.contact_row_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.tvFirstName.text = userArrayList[i].firstName
        viewHolder.tvLastName.text = userArrayList[i].lastName
        viewHolder.tvPhone.text = userArrayList[i].phoneNumber
    }

    override fun getItemCount(): Int {
        return userArrayList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvFirstName: TextView = itemView.findViewById(R.id.tvFirstName)
        val tvLastName: TextView = itemView.findViewById(R.id.tvLastName)
        val tvPhone: TextView = itemView.findViewById(R.id.tvPhone)
    }

    fun updateContacts(drinkies: List<Contact>){
        userArrayList.clear()
        userArrayList.addAll(drinkies)
        notifyDataSetChanged()
    }
}