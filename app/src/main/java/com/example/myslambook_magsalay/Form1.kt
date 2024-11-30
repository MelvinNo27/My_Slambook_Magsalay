package com.example.myslambook_magsalay

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myslambook_magsalay.databinding.ActivityForm1Binding

class Form1 : AppCompatActivity() {

    private lateinit var binding: ActivityForm1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityForm1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext1.setOnClickListener {
            val intent = Intent(this, Form2::class.java)
            startActivity(intent)
            finish()
        }
    }
}
