package com.example.myslambook_magsalay

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myslambook_magsalay.databinding.ActivityForm1Binding

class Form1 : AppCompatActivity() {

    // View Binding instance
    private lateinit var binding: ActivityForm1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize View Binding
        binding = ActivityForm1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Submit Button Click
        binding.btnSubmit.setOnClickListener {
            val User = User(
                firstName = binding.firstName.text.toString(),
                lastName = binding.lastName.text.toString(),
                nickname = binding.nickname.text.toString(),
                friendsCallYou = binding.friendsCallYou.text.toString(),
                likeToCallMe = binding.likeToCallMe.text.toString(),
                email = binding.email.text.toString(),
                status = binding.status.text.toString(),
                address = binding.address.text.toString(),
                contactNumber = binding.contactNumber.text.toString(),
                gender = binding.genderSpinner.selectedItem.toString(),
                birthDate = "${binding.monthSpinner.selectedItem} ${binding.daySpinner.selectedItem}, ${binding.yearSpinner.selectedItem}"
            )

            intent.putExtra("User", User)
            startActivity(Intent(this, List::class.java))

            Toast.makeText(this, "User data submitted successfully!", Toast.LENGTH_SHORT).show()
        }

        binding.backButton.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
