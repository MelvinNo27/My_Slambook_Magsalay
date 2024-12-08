package com.example.myslambook_magsalay

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myslambook_magsalay.databinding.ActivityListBinding

class UserListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("MySlamBook", MODE_PRIVATE)

        // Example data (replace with dynamic fetching from SharedPreferences or a database)
        val users = listOf("User 1", "User 2", "User 3")
        val imageUris = listOf<String?>(null, null, null)

        // Set up RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = UserAdapter(this, users, imageUris)
        binding.recyclerView.adapter = adapter

        // Handle back button click
        binding.ListBackButton.setOnClickListener {
            startActivity(Intent(this, Form2::class.java))
            finish()
        }
    }
}
