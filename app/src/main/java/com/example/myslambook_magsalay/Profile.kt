package com.example.myslambook_magsalay

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myslambook_magsalay.databinding.ActivityProfileBinding
import com.google.android.material.imageview.ShapeableImageView

class Profile : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private val PICK_IMAGE_REQUEST = 1
    private var imageUri: Uri? = null // Store the selected image URI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize profile setup when the edit button is clicked
        binding.editButton.setOnClickListener {
            setupProfile()
        }

        binding.btnNext2.setOnClickListener {
            // Create intent to pass data to the next activity
            val intent = Intent(this, Birthday::class.java)
            intent.putExtra("NICKNAME", binding.Nickname.text.toString()) // Pass the nickname
            // Pass the image URI if it exists
            imageUri?.let { uri ->
                intent.putExtra("PROFILE_IMAGE_URI", uri.toString())
            }
            startActivity(intent)
        }

        // Back button functionality to return to Form2
        binding.ProfileBackButton.setOnClickListener {
            startActivity(Intent(this, Form2::class.java))
            finish()
        }
    }

    // Method to set up the profile, including choosing an image from the gallery
    private fun setupProfile() {
        val profileImage: ShapeableImageView = binding.profileImage
        profileImage.setImageResource(R.drawable.avatar) // Placeholder avatar

        // Edit button (to choose image from gallery)
        binding.editButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, PICK_IMAGE_REQUEST)
        }
    }

    // Handle the result of the image picker
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                PICK_IMAGE_REQUEST -> {
                    data?.data?.let { uri ->
                        // Update profile image
                        binding.profileImage.setImageURI(uri)
                        imageUri = uri // Store the image URI
                        Toast.makeText(this, "Avatar updated successfully!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}

