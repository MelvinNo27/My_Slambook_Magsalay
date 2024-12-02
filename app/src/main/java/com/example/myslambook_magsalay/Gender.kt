package com.example.myslambook_magsalay

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myslambook_magsalay.databinding.ActivityGenderBinding

class Gender : AppCompatActivity() {

    private lateinit var binding: ActivityGenderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGenderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Male Button Click
        binding.btnMale.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            intent.putExtra("GENDER", "Male")  // Send gender to Form3
            startActivity(intent)
            finish()  // Finish current activity
        }

        // Female Button Click
        binding.btnFemale.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            intent.putExtra("GENDER", "Female")  // Send gender to Form3
            startActivity(intent)
            finish()  // Finish current activity
        }
    }
}