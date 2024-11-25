package com.example.myslambook_magsalay

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myslambook_magsalay.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get User Data
        val user = intent.getParcelableExtra<User>("user")

        // Display User Details
        user?.let {
            binding.firstNameView.text = "First Name: ${it.firstName}"
            binding.lastNameView.text = "Last Name: ${it.lastName}"
            binding.nicknameView.text = "Nickname: ${it.nickname}"
            binding.friendsCallYouView.text = "Friends Call You: ${it.friendsCallYou}"
            binding.likeToCallMeView.text = "Like To Call Me: ${it.likeToCallMe}"
            binding.emailView.text = "Email: ${it.email}"
            binding.statusView.text = "Status: ${it.status}"
            binding.addressView.text = "Address: ${it.address}"
            binding.contactNumberView.text = "Contact Number: ${it.contactNumber}"
            binding.genderView.text = "Gender: ${it.gender}"
            binding.birthDateView.text = "Birth Date: ${it.birthDate}"
        }
    }
}
