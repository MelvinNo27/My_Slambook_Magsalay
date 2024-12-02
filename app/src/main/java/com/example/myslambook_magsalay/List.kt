package com.example.myslambook_magsalay

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myslambook_magsalay.databinding.ActivityListBinding

class List : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // Example data
        val users = listOf("User 1", "User 2", "User 3")
        val imageUris = listOf<String?>(null, null, null) // Replace with actual URIs if needed

        // Initialize the adapter
        val adapter = UserAdapter(this, users, imageUris)
        binding.recyclerView.adapter = adapter

        binding.ListBackButton.setOnClickListener {
            // Go back to the previous activity (Form2)
            startActivity(Intent(this, Form2::class.java))
            finish()
        }
    }
}
