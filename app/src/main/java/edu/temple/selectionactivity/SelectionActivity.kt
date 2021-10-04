package edu.temple.selectionactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.recyclerview.widget.*

class SelectionActivity : AppCompatActivity() {

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

        // create new on-click event listener for recycler view
        val myOnClickListener = View.OnClickListener {
            val pos = recyclerView.getChildAdapterPosition(it)
            selectedImage.setImageResource(imageList[pos].imageSrc)
            selectedText.text = imageList[pos].imageDesc
        }

        // finally, create the adapter for the recycler view
        recyclerView.adapter = SelectionAdapter(this@SelectionActivity, imageList, myOnClickListener)
    }

    // declare all image sources and text
    // < same pictures as last lab, but with different descriptions >
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