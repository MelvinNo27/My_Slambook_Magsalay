package com.example.myslambook_magsalay

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myslambook_magsalay.databinding.ActivityRowsListBinding

class RowList : AppCompatActivity() {

    private lateinit var binding: ActivityRowsListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityRowsListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewButtonList.setOnClickListener {
            startActivity(Intent(this, DetailsActivity::class.java))
            finish()
        }

    }
}
