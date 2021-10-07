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