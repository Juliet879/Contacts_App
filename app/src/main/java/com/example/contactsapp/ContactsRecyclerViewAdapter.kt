package com.example.contactsapp

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.w3c.dom.Text
import java.io.ByteArrayOutputStream

class ContactsRecyclerViewAdapter(var contactsList:List<Contacts>,var context: Context):RecyclerView.Adapter<ContactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.contact_list_item,parent,false)
        return ContactViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        var  currentContact = contactsList.get(position)
        holder.name.text = currentContact.name
        holder.phone.text = currentContact.phone
        holder.email.text = currentContact.email
        Picasso.get()
            .load(currentContact.imageUrl)
            .resize(50,50)
            .centerCrop()
            .placeholder(R.drawable.placed)
            .into(holder.image)

        holder.cvContacts.setOnClickListener {
            var intent = Intent(context,ViewContactActivity::class.java)
            intent.putExtra("name",currentContact.name)
            intent.putExtra("phone",currentContact.phone)
            intent.putExtra("email",currentContact.email)
            intent.putExtra("image",currentContact.imageUrl)
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