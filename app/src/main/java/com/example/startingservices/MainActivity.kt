package com.example.startingservices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.number)
        val startButton = findViewById<Button>(R.id.button)

        startButton.setOnClickListener {
            val startValue = editText.text.toString().toIntOrNull()

            if (startValue != null) {
                val serviceIntent = Intent(this, TimerService::class.java)
                serviceIntent.putExtra("startValue", startValue)
                startService(serviceIntent)
            } else {
                // Handle invalid input (non-integer)
                Toast.makeText(this, "Invalid input. Please enter an integer.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
