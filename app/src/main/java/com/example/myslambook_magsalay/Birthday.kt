package com.example.myslambook_magsalay

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myslambook_magsalay.databinding.ActivityDateofbirthBinding
import kotlin.collections.List


class Birthday : AppCompatActivity() {

    private lateinit var bindingForm: ActivityDateofbirthBinding
    private lateinit var sharedPreferences: SharedPreferences

    private val PICK_IMAGE_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the SharedPreferences
        sharedPreferences = getSharedPreferences("MySlamBook", MODE_PRIVATE)

        // Use view binding to inflate Form1 and Profile layout
        bindingForm = ActivityDateofbirthBinding.inflate(layoutInflater)

        // Display the Form1 (for user details) layout by default
        setContentView(bindingForm.root)

        setupForm1()
    }

    private fun setupForm1() {

        val months = resources.getStringArray(R.array.monthName)
        val monthAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, months)
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        bindingForm.monthSpinner.adapter = monthAdapter


        val days = resources.getStringArray(R.array.monthDay)
        val dayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, days)
        dayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        bindingForm.daySpinner.adapter = dayAdapter


        val years = resources.getStringArray(R.array.Years)
        val yearAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, years)
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        bindingForm.yearSpinner.adapter = yearAdapter

        // Submit Button Click
        bindingForm.btnNext3.setOnClickListener {
            // Save user data in SharedPreferences
            val editor = sharedPreferences.edit()
            editor.putString(
                "birthDate",
                "${bindingForm.monthSpinner.selectedItem} ${bindingForm.daySpinner.selectedItem}, ${bindingForm.yearSpinner.selectedItem}"
            )
            editor.apply()

            startActivity(Intent(this, Form3::class.java))

            // Show confirmation toast
            Toast.makeText(this, "User data submitted successfully!", Toast.LENGTH_SHORT).show()
            finish()
        }

        // Back Button Click for Form1
        bindingForm.backDateOfBirthButton.setOnClickListener {
            startActivity(Intent(this, Form2::class.java))
            finish()
        }
    }

}
