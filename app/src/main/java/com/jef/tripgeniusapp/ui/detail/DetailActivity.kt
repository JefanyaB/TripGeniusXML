package com.jef.tripgeniusapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.jef.tripgeniusapp.R
import com.jef.tripgeniusapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {


    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpUser()
    }
    private fun setUpUser(){
        val name = intent.getStringExtra("userName")
        Log.d("udah", name.toString())
        val timeStamp = intent.getStringExtra("timeStamp")
        Log.d("udah", timeStamp.toString())
        val description = intent.getStringExtra("description")
        Log.d("udah", description.toString())
        val photo = intent.getStringExtra("photo")
        Log.d("udah", photo.toString())
//
//        Glide.with(applicationContext).load(photo).into(binding.storyImageView)
//        binding.name.text = name
//        binding.description.text = description
//        binding.timestamp.text = timeStamp

    }
}