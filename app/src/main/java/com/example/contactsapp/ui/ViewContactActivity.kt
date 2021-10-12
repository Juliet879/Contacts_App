package com.example.contactsapp.ui

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.content.FileProvider
import com.example.contactsapp.R
import com.example.contactsapp.databinding.ActivityViewContactBinding
import com.example.contactsapp.models.Contact
import com.example.contactsapp.viewmodels.ContactsViewModel
import java.io.File
import java.util.jar.Manifest

class ViewContactActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewContactBinding
    val contactViewModel: ContactsViewModel by viewModels()
    lateinit var photoFile: File
    lateinit var myContact: Contact


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val contactId = intent.getIntExtra("ID", 0)
        contactViewModel.getAllContactById(contactId)
    }

    override fun onResume() {
        super.onResume()
        contactViewModel.contactLiveData.observe(this, { contact ->
            binding.tvNameView.text = contact.name
            binding.tvEmailView.text = contact.email
            binding.tvPhoneView.text = contact.phone
            if (contact.imageUrl?.isNotEmpty()!!) {
                binding.imgCamera.setImageBitmap(BitmapFactory.decodeFile(contact.imageUrl))
            }
            myContact = contact
        })


// Picture intent responsible for taking the picture
        binding.imgCamera.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            photoFile = getPhotoFile("photo_${System.currentTimeMillis()}")
            val fileProvider =
                FileProvider.getUriForFile(this, "com.example.contactsapp.provider", photoFile)
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileProvider)
            cameraLauncher.launch(takePictureIntent)
        }
        binding.ivGallery.setOnClickListener {
            clickPickPhoto()
        }
    }

    private fun clickPickPhoto() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                pickPhotoFromGallery()
            } else {
                val permissions = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                requestPermissions(permissions, 111)
            }
        } else {
            pickPhotoFromGallery()
        }
    }

    //request code helps you to identify the request you received
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            111 -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    pickPhotoFromGallery()
                } else {
                    Toast.makeText(this, "Permission required to proceed", Toast.LENGTH_LONG).show()
                }

            }
        }
    }



    var galleryLaucher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val imageUri = result.data?.data
                val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, imageUri)
                binding.imgView.setImageBitmap(bitmap)
//            myContact.imageUrl =
//            contactViewModel.saveContact(myContact)
            }
        }

    private fun pickPhotoFromGallery() {
        val gallery = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        galleryLaucher.launch(gallery)
    }

    var cameraLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val takenPhoto = BitmapFactory.decodeFile(photoFile.absolutePath)
//                val imageUri = result.data?.data
//                var bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, imageUri)
                binding.imgCamera.setImageBitmap(takenPhoto)
                myContact.imageUrl = photoFile.absolutePath    //give path of the photo
                contactViewModel.saveContact(myContact)        //save the contact to the db
            }
        }

    //    Access external Storage
    fun getPhotoFile(fileName: String): File {
        val storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(fileName, "jpeg", storageDir)
    }
}