package com.example.contects.activities.contacts

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contects.databinding.ItemContactBinding
import com.example.contects.model.Contact

class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    private var contactList = mutableListOf<Contact>()
    var onClickDelete: ((Int) -> Unit)? = null

    class ContactViewHolder(val binding: ItemContactBinding) : RecyclerView.ViewHolder(binding.root)

    fun deleteContact(position: Int) {
        if (position >= 0 && position < contactList.size) {
            contactList.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    fun addContact(contact: Contact){
        contactList.add(contact)
        notifyItemInserted(contactList.size-1)
    }

    fun isEmpty() = contactList.isEmpty()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding = ItemContactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactViewHolder(binding)
    }

    override fun getItemCount(): Int = contactList.size

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contactList[position]

        holder.binding.tvName.text = contact.name
        holder.binding.tvEmail.text = contact.number
        holder.binding.tvNumber.text = contact.email

        holder.binding.ivDelete.setOnClickListener {
            onClickDelete?.invoke(position)
        }
    }

    fun setContactList(list: List<Contact>) {
        contactList.clear()
        contactList.addAll(list)
        notifyDataSetChanged()
    }
}



