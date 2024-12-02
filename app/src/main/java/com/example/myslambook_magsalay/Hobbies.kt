package com.example.myslambook_magsalay

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myslambook_magsalay.databinding.ActivityHobbiesBinding


class Hobbies : AppCompatActivity() {

    private lateinit var bindingForm: ActivityHobbiesBinding
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the SharedPreferences
        sharedPreferences = getSharedPreferences("MySlamBook", MODE_PRIVATE)

        // Use view binding to inflate Form1 and Profile layout
        bindingForm = ActivityHobbiesBinding.inflate(layoutInflater)

        // Display the Form1 (for user details) layout by default
        setContentView(bindingForm.root)

        setupForm3()
    }

    private fun setupForm3() {

        // Submit Button Click
        bindingForm.btnSubmit.setOnClickListener {
            // Save user data in SharedPreferences
            val editor = sharedPreferences.edit()
            editor.putString("Hobbies", bindingForm.Hobbies.text.toString())
            editor.putString("WhoInspiresYouTheMost", bindingForm.WhoInspiresYouTheMost.text.toString())
            editor.putString("YourBiggestFear", bindingForm.YourBiggestFear.text.toString())
            editor.putString("WhatMakesYouHappy", bindingForm.WhatMakesYouHappy.text.toString())
            editor.putString("YourDreamDestination", bindingForm.YourDreamDestination.text.toString())
            editor.putString("WhatsYourLuckyNumber", bindingForm.WhatsYourLuckyNumber.text.toString())
            editor.apply()

            startActivity(Intent(this, Form2::class.java))

            // Show confirmation toast
            Toast.makeText(this, "User data submitted successfully!", Toast.LENGTH_SHORT).show()
            finish()
        }

        // Back Button Click for Form1
        bindingForm.backForm3Button.setOnClickListener {
            startActivity(Intent(this, Favorite::class.java))
            finish()
        }
    }

}
