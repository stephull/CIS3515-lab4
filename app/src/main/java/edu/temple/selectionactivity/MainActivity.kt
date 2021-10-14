package edu.temple.selectionactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.recyclerview.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val selection = SelectionFragment()
        val display = DisplayFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.selection_container, selection)
            .add(R.id.display_container, display)
            .commit()
    }
}