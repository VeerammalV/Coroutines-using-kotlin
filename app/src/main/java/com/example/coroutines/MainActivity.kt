package com.example.coroutines

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.coroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var counter: Int= 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            binding.countNumber.text = counter++.toString()
        }

        binding.downloadButton.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                for(i in 1 .. 100000)
                    Log.i("TAG", "Downloding $i in ${Thread.currentThread().name}")
                }
            }
    }
}