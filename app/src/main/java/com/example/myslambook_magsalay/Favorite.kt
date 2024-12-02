package com.example.myslambook_magsalay

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myslambook_magsalay.databinding.ActivityFavoriteBinding
import kotlin.collections.List


class Favorite : AppCompatActivity() {

    private lateinit var bindingForm: ActivityFavoriteBinding
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the SharedPreferences
        sharedPreferences = getSharedPreferences("MySlamBook", MODE_PRIVATE)

        // Use view binding to inflate Form1 and Profile layout
        bindingForm = ActivityFavoriteBinding.inflate(layoutInflater)

        // Display the Form1 (for user details) layout by default
        setContentView(bindingForm.root)

        setupForm3()
    }

    private fun setupForm3() {

        // Submit Button Click
        bindingForm.btnNext4.setOnClickListener {
            // Save user data in SharedPreferences
            val editor = sharedPreferences.edit()
            editor.putString("movies", bindingForm.movies.text.toString())
            editor.putString("Song", bindingForm.Song.text.toString())
            editor.putString("Food", bindingForm.Food.text.toString())
            editor.putString("Color", bindingForm.Color.text.toString())
            editor.putString("Sports", bindingForm.Sports.text.toString())
            editor.putString("Celebrity", bindingForm.Celebrity.text.toString())
            editor.apply()

            startActivity(Intent(this, Hobbies::class.java))

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
