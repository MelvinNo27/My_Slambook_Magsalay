package com.example.myslambook_magsalay

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myslambook_magsalay.databinding.ActivityForm3Binding
import kotlin.collections.List


class Form3 : AppCompatActivity() {

    private lateinit var bindingForm: ActivityForm3Binding
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the SharedPreferences
        sharedPreferences = getSharedPreferences("MySlamBook", MODE_PRIVATE)

        // Use view binding to inflate Form1 and Profile layout
        bindingForm = ActivityForm3Binding.inflate(layoutInflater)

        // Display the Form1 (for user details) layout by default
        setContentView(bindingForm.root)

        setupForm3()
    }

    private fun setupForm3() {

        // Submit Button Click
        bindingForm.btnNext4.setOnClickListener {
            // Save user data in SharedPreferences
            val editor = sharedPreferences.edit()
            editor.putString("firstName", bindingForm.firstName.text.toString())
            editor.putString("lastName", bindingForm.lastName.text.toString())
            editor.putString("email", bindingForm.email.text.toString())
            editor.putString("address", bindingForm.address.text.toString())
            editor.putString("contactNumber", bindingForm.contactNumber.text.toString())
            editor.putString("friendsCallYou", bindingForm.friendsCallYou.text.toString())
            editor.apply()

            startActivity(Intent(this, Favorite::class.java))

            // Show confirmation toast
            Toast.makeText(this, "User data submitted successfully!", Toast.LENGTH_SHORT).show()
            finish()
        }

        // Back Button Click for Form1
        bindingForm.backForm3Button.setOnClickListener {
            startActivity(Intent(this, Form2::class.java))
            finish()
        }
    }

}
