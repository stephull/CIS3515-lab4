package edu.temple.selectionactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.*

class SelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection)

        // declare image list and recyclerview
        val imageList = getImageList()
        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)

        // declare layout manager for recyclerview
        recyclerView.layoutManager = GridLayoutManager(this@SelectionActivity, 3)

        // adapter for image list
        val adapter = SelectionAdapter(this@SelectionActivity, imageList)
        recyclerView.adapter = adapter

        // intent for second activity (display)
        val newIntent = Intent(this, DisplayActivity::class.java)

        // assemble on-click listener using intent for any picture selected
        adapter.setOnItemClickListener(object : SelectionAdapter.OnItemClickListener {
            override fun onItemClick(pos: Int) {
                val item = imageList[pos]
                newIntent.putExtra("image_text", item.imageDesc)
                newIntent.putExtra("image_source", item.imageSrc)
                startActivity(newIntent)
            }
        })
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