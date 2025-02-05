package com.example.contects.activities.contacts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.contects.databinding.ActivityContactBinding
import com.example.contects.model.Contact

class ActivityContact : AppCompatActivity() {
    lateinit var binding: ActivityContactBinding
    val ContactList = mutableListOf<Contact>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        SetUIStat()
    }

    private fun SetUIStat() {

    }
}