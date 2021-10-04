package edu.temple.selectionactivity

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class SelectionAdapter (_context : Context, _imageList : ArrayList<MyPicture>, _myOnClick: View.OnClickListener) : RecyclerView.Adapter<SelectionAdapter.MyViewHolder>() {
    // declare variables from parameters above
    private val context = _context
    private val imageList = _imageList
    private val myOnClick = _myOnClick

    // declare width + height of layout params
    private val wh = 300

    // view holder class
    class MyViewHolder(_view: ImageView, myOnClick: View.OnClickListener) : RecyclerView.ViewHolder(_view) {
        val imageView = _view.apply {setOnClickListener(myOnClick)}
    }

    // create view holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ImageView(context).apply {
            layoutParams = ViewGroup.LayoutParams(wh, wh)
        }, myOnClick)
    }

    // bind view holder
    override fun onBindViewHolder(holder: MyViewHolder, pos: Int) {
        holder.imageView.setImageResource(imageList[pos].imageSrc)
    }

    // return the size of image list
    override fun getItemCount(): Int {
        return imageList.size
    }
}