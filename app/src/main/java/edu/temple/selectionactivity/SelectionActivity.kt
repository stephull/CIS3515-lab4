package edu.temple.selectionactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SelectionActivity : AppCompatActivity() {

    data class MyPicture (val myPictureDesc : String? , val myPictureSrc : Int)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection)

        // object class declaration
        val imageList = getImageList()

        // recycler view properties
        val recyclerView : RecyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = GridLayoutManager(this@SelectionActivity, 2)
        //recyclerView.adapter = SelectionAdapter(this@SelectionActivity, imageList)

    }

    private fun getImageList() : ArrayList<MyPicture> {
        return arrayListOf(

        )
    }
}