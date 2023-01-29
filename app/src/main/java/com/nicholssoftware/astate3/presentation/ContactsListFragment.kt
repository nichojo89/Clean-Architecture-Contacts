package com.nicholssoftware.astate3.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.nicholssoftware.astate3.databinding.FragmentContactsListBinding
import com.nicholssoftware.astate3.framework.viewmodels.ContactsViewModel
import com.nicholssoftware.astate3.presentation.utils.ContactRowAdapter
import com.nicholssoftware.astate3.presentation.utils.ListAction

class ContactsListFragment : Fragment(), ListAction {
    private lateinit var _binding: FragmentContactsListBinding
    private val binding get() = _binding
    private lateinit var contactRowAdapter: ContactRowAdapter

    private val contactViewModel: ContactsViewModel by lazy {
        ViewModelProvider(this).get(ContactsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContactsListBinding.inflate(inflater,container,false)
        binding.fabAddContacts.setOnClickListener {
            val action = ContactsListFragmentDirections.actionContactsListFragmentToAddContactFragment()
            Navigation.findNavController(binding.root).navigate(action)
        }
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        contactRowAdapter = ContactRowAdapter(arrayListOf())
        binding.rvContacts.apply {
            adapter = contactRowAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        observeViewModel()
        contactViewModel.getContacts()
    }

    override fun onResume() {
        super.onResume()
        contactViewModel.getContacts()
    }

    private fun observeViewModel(){
        contactViewModel.contacts.observe(viewLifecycleOwner, Observer { contacts ->
            contactRowAdapter.updateContacts(contacts)
        })
    }

    override fun onClick(id: Long) {
        //TODO navigate to contact details
    }
}