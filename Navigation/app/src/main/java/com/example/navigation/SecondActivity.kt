package com.example.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val text = intent?.extras?.getString("text")
        Toast.makeText(this, "Message from main activity: $text", Toast.LENGTH_LONG).show()
    }
}