package com.example.contactsapp

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.contactsapp.models.Contact
import com.example.contactsapp.ui.ViewContactActivity

class ContactsRecyclerViewAdapter(var contactsList:List<Contact>, var context: Context):RecyclerView.Adapter<ContactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.contact_list_item,parent,false)
        return ContactViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val currentContact = contactsList.get(position)
        holder.name.text = currentContact.name
        holder.phone.text = currentContact.phone
        holder.email.text = currentContact.email
        holder.image.setImageBitmap(BitmapFactory.decodeFile(currentContact.imageUrl))
//        Picasso.get()
//            .load(currentContact.imageUrl)
//            .resize(50,50)
//            .centerCrop()
//            .placeholder(R.drawable.placed)
//            .into(holder.image)

        holder.cvContacts.setOnClickListener {
            val intent = Intent(context, ViewContactActivity::class.java)
            intent.putExtra("ID",currentContact.id)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
        return contactsList.size
    }

}
class ContactViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    var name = itemView.findViewById<TextView>(R.id.tvName)
    var phone = itemView.findViewById<TextView>(R.id.tvPhone)
    var email = itemView.findViewById<TextView>(R.id.tvEmail)
    var image = itemView.findViewById<ImageView>(R.id.imgContact)
    var cvContacts = itemView.findViewById<CardView>(R.id.cvContacts)
}