package edu.temple.selectionactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        val selectedImage : ImageView = findViewById(R.id.displayImage)
        val selectedText : TextView = findViewById(R.id.displayText)

        if (intent.hasExtra("image_source") && intent.hasExtra("image_text")) {
            val image = intent.getIntExtra("image_source", 0)
            val text = intent.getStringExtra("image_text")

            selectedImage.setImageResource(image)
            selectedText.text = text
        }
    }
}