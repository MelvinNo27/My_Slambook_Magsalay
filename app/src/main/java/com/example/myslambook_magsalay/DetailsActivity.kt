package com.example.myslambook_magsalay

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myslambook_magsalay.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    private lateinit var sharedPreferences: SharedPreferences
    private var userName: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("MySlamBook", MODE_PRIVATE)

        // Retrieve the clicked user's name from the intent
        userName = intent.getStringExtra("userName") ?: ""

        // Populate fields with user-specific data
        binding.Nickname.setText(sharedPreferences.getString("${userName}_nickname", ""))
        binding.firstName.setText(sharedPreferences.getString("${userName}_firstName", ""))
        binding.lastName.setText(sharedPreferences.getString("${userName}_lastName", ""))
        binding.email.setText(sharedPreferences.getString("${userName}_email", ""))
        binding.address.setText(sharedPreferences.getString("${userName}_address", ""))
        binding.contactNumber.setText(sharedPreferences.getString("${userName}_contactNumber", ""))
        binding.friendsCallYou.setText(sharedPreferences.getString("${userName}_friendsCallYou", ""))
        binding.Age.setText(sharedPreferences.getString("${userName}_age", ""))
        binding.Gender.setText(sharedPreferences.getString("${userName}_gender", ""))
        binding.movies.setText(sharedPreferences.getString("${userName}_movies", ""))
        binding.Song.setText(sharedPreferences.getString("${userName}_song", ""))
        binding.Food.setText(sharedPreferences.getString("${userName}_food", ""))
        binding.Color.setText(sharedPreferences.getString("${userName}_color", ""))
        binding.Sports.setText(sharedPreferences.getString("${userName}_sports", ""))
        binding.Celebrity.setText(sharedPreferences.getString("${userName}_celebrity", ""))
        binding.Hobbies.setText(sharedPreferences.getString("${userName}_hobbies", ""))
        binding.WhoInspiresYouTheMost.setText(sharedPreferences.getString("${userName}_inspiration", ""))
        binding.YourBiggestFear.setText(sharedPreferences.getString("${userName}_biggestFear", ""))
        binding.WhatMakesYouHappy.setText(sharedPreferences.getString("${userName}_makesYouHappy", ""))
        binding.YourDreamDestination.setText(sharedPreferences.getString("${userName}_dreamDestination", ""))
        binding.WhatsYourLuckyNumber.setText(sharedPreferences.getString("${userName}_luckyNumber", ""))

        // Handle back button click
        binding.DetailsBackButton.setOnClickListener {
            startActivity(Intent(this, List::class.java))
            finish()
        }

        // Handle update button click
        binding.btnUpdate.setOnClickListener {
            saveDetails()
        }
    }

    private fun saveDetails() {
        val editor = sharedPreferences.edit()
        editor.putString("${userName}_nickname", binding.Nickname.text.toString())
        editor.putString("${userName}_firstName", binding.firstName.text.toString())
        editor.putString("${userName}_lastName", binding.lastName.text.toString())
        editor.putString("${userName}_email", binding.email.text.toString())
        editor.putString("${userName}_address", binding.address.text.toString())
        editor.putString("${userName}_contactNumber", binding.contactNumber.text.toString())
        editor.putString("${userName}_friendsCallYou", binding.friendsCallYou.text.toString())
        editor.putString("${userName}_age", binding.Age.text.toString())
        editor.putString("${userName}_gender", binding.Gender.text.toString())
        editor.putString("${userName}_movies", binding.movies.text.toString())
        editor.putString("${userName}_song", binding.Song.text.toString())
        editor.putString("${userName}_food", binding.Food.text.toString())
        editor.putString("${userName}_color", binding.Color.text.toString())
        editor.putString("${userName}_sports", binding.Sports.text.toString())
        editor.putString("${userName}_celebrity", binding.Celebrity.text.toString())
        editor.putString("${userName}_hobbies", binding.Hobbies.text.toString())
        editor.putString("${userName}_inspiration", binding.WhoInspiresYouTheMost.text.toString())
        editor.putString("${userName}_biggestFear", binding.YourBiggestFear.text.toString())
        editor.putString("${userName}_makesYouHappy", binding.WhatMakesYouHappy.text.toString())
        editor.putString("${userName}_dreamDestination", binding.YourDreamDestination.text.toString())
        editor.putString("${userName}_luckyNumber", binding.WhatsYourLuckyNumber.text.toString())
        editor.apply()
    }
}
