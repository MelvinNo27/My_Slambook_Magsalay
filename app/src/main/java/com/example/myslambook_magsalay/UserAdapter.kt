package com.example.myslambook_magsalay

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myslambook_magsalay.databinding.ActivityRowsListBinding
import kotlin.collections.List

class UserAdapter(
    private val context: Context,
    private val users: List<String>,
    private val imageUris: List<String?> // List of image URIs
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    inner class UserViewHolder(val binding: ActivityRowsListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ActivityRowsListBinding.inflate(LayoutInflater.from(context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val userName = users[position]
        val imageUri = imageUris[position]

        holder.binding.fullNameList.text = userName

        if (imageUri != null) {
            holder.binding.profileImageView.setImageURI(Uri.parse(imageUri))
        } else {
            holder.binding.profileImageView.setImageResource(R.drawable.avatar)
        }

        // Handle click events to navigate to DetailsActivity
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("userName", userName)
            context.startActivity(intent)
        }
    }


    override fun getItemCount(): Int {
        return users.size
    }
}
