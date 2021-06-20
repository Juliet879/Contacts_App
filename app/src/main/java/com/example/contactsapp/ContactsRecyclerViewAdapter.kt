package com.example.contactsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class ContactsRecyclerViewAdapter(var contactsList:List<Contacts>):RecyclerView.Adapter<ContactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.contact_list_item,parent,false)
        return ContactViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        var  currentContact = contactsList.get(position)
        holder.name.text = currentContact.name
        holder.phone.text = currentContact.phone
        holder.email.text = currentContact.email

    }

    override fun getItemCount(): Int {
        return contactsList.size
    }

}
class ContactViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    var name = itemView.findViewById<TextView>(R.id.tvName)
    var phone = itemView.findViewById<TextView>(R.id.tvPhone)
    var email = itemView.findViewById<TextView>(R.id.tvEmail)
}