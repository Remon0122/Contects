package com.example.contects.activities.contacts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.contects.activities.utils.ValidationUtils.validateEmail
import com.example.contects.databinding.ActivityContactBinding
import com.example.contects.databinding.BottomSheetBinding
import com.example.contects.model.Contact
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.example.contects.activities.utils.ValidationUtils.validateName
import com.example.contects.activities.utils.ValidationUtils.validatePhone

class ActivityContact : AppCompatActivity() {
    lateinit var binding: ActivityContactBinding
    private val ContactList = mutableListOf<Contact>()
    private val adapter = ContactAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        updateUIState()
        initContactRv()
        onAddContactClick()
    }



    private fun onAddContactClick() {
        binding.fabAddContact.setOnClickListener{
            val bottomSheetDialog = BottomSheetDialog(this)
            val bottomSheetBinding = BottomSheetBinding.inflate(layoutInflater)
            bottomSheetDialog.setContentView(bottomSheetBinding.root)
            val name = bottomSheetBinding.nameEdit.text?.trim().toString()
            val email = bottomSheetBinding.emailEdit.text?.trim().toString()
            val phone = bottomSheetBinding.PhoneEdit.text?.trim().toString()
            bottomSheetDialog.show()
            bottomSheetBinding.btnAddContact.setOnClickListener{
                if (!validateTextField(bottomSheetBinding)){
                    return@setOnClickListener
                }
            val contact = Contact(name,email,phone)
            adapter.addContact(contact)
            updateUIState()
            }
        }
    }
    private fun validateTextField(binding: BottomSheetBinding): Boolean {
        val name = binding.nameEdit.text?.trim().toString()
        val email = binding.emailEdit.text?.trim().toString()
        val phone = binding.PhoneEdit.text?.trim().toString()

        val nameError = validateName(name)
        val emailError = validateEmail(email)
        val phoneError = validatePhone(phone)

        binding.namTil.error = nameError
        binding.emailTil.error = emailError
        binding.phoneTil.error = phoneError

        return nameError == null && emailError == null && phoneError == null
    }

    private fun initContactRv() {
        binding.rvContact.adapter = adapter
        adapter.setContactList(ContactList)
        adapter.onClickDelete = { Position->
            adapter.deleteContact(Position)
            updateUIState()
        }
    }

    private fun updateUIState() {
        if (adapter.isEmpty()){
            updateUIForStates()
        }else{
            updateUIForSuccess()
        }
    }

    private fun updateUIForSuccess() {
        binding.rvContact.isVisible = true
        binding.emptyView.isVisible = false
    }

    private fun updateUIForStates() {
        binding.rvContact.isVisible = false
        binding.emptyView.isVisible = true
    }
}