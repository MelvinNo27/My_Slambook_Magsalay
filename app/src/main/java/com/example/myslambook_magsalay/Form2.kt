package com.example.myslambook_magsalay

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myslambook_magsalay.databinding.ActivityForm2Binding
import kotlin.collections.List

class Form2 : AppCompatActivity() {

    private lateinit var binding: ActivityForm2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityForm2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCreate.setOnClickListener {
            val intent = Intent(this, Gender::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnList.setOnClickListener {
            val intent = Intent(this, UserListActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
