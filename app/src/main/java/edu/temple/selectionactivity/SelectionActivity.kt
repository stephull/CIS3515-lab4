package edu.temple.selectionactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class SelectionActivity : AppCompatActivity() {

    data class MyPicture (val myPictureDesc : String? , val myPictureSrc : Int)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection)

        // call variables for selecting image + text
        val selectedImage : ImageView = findViewById(R.id.displayImage)
        val selectedText : TextView = findViewById(R.id.displayText)

        // object class declaration
        val imageList = getImageList()

        // recycler view properties
        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this@SelectionActivity, 2)
        //recyclerView.adapter = SelectionAdapter(this@SelectionActivity, imageList)

    }

    // declare all image sources and text
    private fun getImageList(): ArrayList<MyPicture> {
        return arrayListOf(
            MyPicture("Astronaut", R.drawable.astronaut),
            MyPicture("Bull", R.drawable.bull),
            MyPicture("Diver", R.drawable.diver),
            MyPicture("Sunset", R.drawable.dusk),
            MyPicture("Lush Forest", R.drawable.forest),
            MyPicture("Over the Horizon", R.drawable.horizon),
            MyPicture("Northern Lights", R.drawable.lights),
            MyPicture("Nighttime", R.drawable.night),
            MyPicture("Rice Terraces", R.drawable.rice_terraces),
            MyPicture("Hot Desert", R.drawable.sand),
            MyPicture("Sunrise", R.drawable.sunrise),
            MyPicture("Waterfall", R.drawable.waterfall)
        )
    }
}