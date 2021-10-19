package edu.temple.selectionactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.recyclerview.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var selection : SelectionFragment
    private lateinit var display : DisplayFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val instructText = findViewById<TextView>(R.id.instructText)
        selection = SelectionFragment()
        display = DisplayFragment()

        // fragment manager for transaction and execution of fragment(s)
        this@MainActivity.supportFragmentManager.beginTransaction()
            .add(R.id.displayFCV, display)
            .add(R.id.selectionFCV, selection)
            .commit()



    }
}