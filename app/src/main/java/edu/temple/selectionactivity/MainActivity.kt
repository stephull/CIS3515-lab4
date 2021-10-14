package edu.temple.selectionactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.recyclerview.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var selection: SelectionFragment
    lateinit var display: DisplayFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        selection = SelectionFragment()
        display = DisplayFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.selection_container, selection)
            .add(R.id.display_container, display)
            .commit()
    }

    // declare all image sources and text
    // < same pictures as last lab, but with different descriptions >
    private fun getImageList(): ArrayList<MyPicture> {
        val arr = resources.getStringArray(R.array.display_text_array)
        var i = 0
        return arrayListOf(
            MyPicture(arr[i++], R.drawable.astronaut),
            MyPicture(arr[i++], R.drawable.bull),
            MyPicture(arr[i++], R.drawable.diver),
            MyPicture(arr[i++], R.drawable.dusk),
            MyPicture(arr[i++], R.drawable.forest),
            MyPicture(arr[i++], R.drawable.horizon),
            MyPicture(arr[i++], R.drawable.lights),
            MyPicture(arr[i++], R.drawable.night),
            MyPicture(arr[i++], R.drawable.rice_terraces),
            MyPicture(arr[i++], R.drawable.sand),
            MyPicture(arr[i++], R.drawable.sunrise),
            MyPicture(arr[i], R.drawable.waterfall)
        )
    }
}