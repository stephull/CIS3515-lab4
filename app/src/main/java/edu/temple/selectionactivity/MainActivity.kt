package edu.temple.selectionactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.recyclerview.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // create instances of fragments
        val selectionFragment = SelectionFragment.newInstance(getImageList())
        val displayFragment = DisplayFragment()

        // fragment manager for transaction and execution of fragment(s)
        supportFragmentManager.beginTransaction()
            .add(R.id.selectionFCV, selectionFragment, "selection_tag")
            .add(R.id.displayFCV, displayFragment, "display_tag")
            .commit()
    }

    // declare all image sources and text
    private fun getImageList(): ArrayList<MyPicture> {
        val arr = resources.getStringArray(R.array.pictures_array)
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