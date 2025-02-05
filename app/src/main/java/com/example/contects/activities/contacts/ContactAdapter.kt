package com.example.contects.activities.contacts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contects.databinding.ItemContactBinding
import com.example.contects.model.Contact

class ContactAdapter(val ContactList : List<Contact>): RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    class ContactViewHolder(val binding : ItemContactBinding):
        RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val ViewBinding = ItemContactBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ContactViewHolder(ViewBinding)
    }

    override fun getItemCount(): Int {
        return ContactList.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = ContactList[position]

        holder.binding.Name.text = contact.name
        holder.binding.Phone.text = contact.number
        holder.binding.Email.text = contact.email

        holder.binding.delete.setOnClickListener{
            
        }
    }

}
