package com.example.myslambook_magsalay

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.myslambook_magsalay.databinding.ActivityListBinding

class List : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding
    private val users = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get User Data from Intent
        val user = intent.getParcelableExtra<User>("user")
        user?.let { users.add(it) }

        // Set up ListView with Adapter
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_2,
            android.R.id.text1,
            users.map { "${it.firstName} ${it.lastName}" }
        )
        binding.listView.adapter = adapter

        // Handle Item Click to View Details
        binding.listView.setOnItemClickListener { _, _, position, _ ->
            val selectedUser = users[position]
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("user", selectedUser)
            startActivity(intent)
        }

        binding.ListBackButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
