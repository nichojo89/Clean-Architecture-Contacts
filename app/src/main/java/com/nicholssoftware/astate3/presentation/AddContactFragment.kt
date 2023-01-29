package com.nicholssoftware.astate3.presentation

import android.os.Bundle
import android.telephony.PhoneNumberUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.nicholssoftware.astate3.databinding.FragmentAddContactBinding
import com.nicholssoftware.astate3.framework.viewmodels.AddContactViewModel
import com.nicholssoftware.core.data.Contact

class AddContactFragment : Fragment() {
    private lateinit var _binding: FragmentAddContactBinding
    private val binding get() = _binding

    private val  viewModel: AddContactViewModel by lazy {
        ViewModelProvider(this).get(AddContactViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddContactBinding.inflate(inflater,container,false)
        binding.btnAddContact.setOnClickListener {
            val firstname = binding.etFirstName.text.toString()
            val lastname = binding.etlastName.text.toString()
            val phone  = binding.etPhoneNumber.text.toString()

            if(firstname != "" && lastname != "" && phone != ""){
                //Add contact
                val contact = Contact(firstname,lastname,phone)
                viewModel.addContact(contact)
                Navigation.findNavController(binding.root).popBackStack()
            } else {
                //show warning
                binding.etFirstName.error = if(firstname == "")  "First name required" else null
                binding.etlastName.error = if(lastname == "") "Last name required" else null
                binding.etPhoneNumber.error = if(phone == "" || PhoneNumberUtils.isGlobalPhoneNumber(phone)) "Invalid phone #" else null
            }

        }
        return binding.root
    }
}