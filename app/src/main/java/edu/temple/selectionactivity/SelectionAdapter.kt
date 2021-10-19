package edu.temple.selectionactivity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class SelectionAdapter(_context: Context, _imageList: ArrayList<MyPicture>) : RecyclerView.Adapter<SelectionAdapter.MyViewHolder>(){
    private val context = _context
    private val imageList = _imageList
    private val wh = 345

    interface OnItemClickListener {
        fun onItemClick(pos: Int)
    }

    private lateinit var myListener : OnItemClickListener
    fun setOnItemClickListener(listener: OnItemClickListener) {
        myListener = listener
    }

    // view holder class
    class MyViewHolder(view: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(view) {
        val recyclerViewImage: ImageView = view.findViewById(R.id.recyclerViewImage)
        init {
            view.setOnClickListener { listener.onItemClick(adapterPosition) }
        }
    }

    // create view holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : MyViewHolder {
        val holderItem = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview, parent, false)
        holderItem.apply {
            layoutParams = ViewGroup.LayoutParams(wh, wh)
        }
        return MyViewHolder(holderItem, myListener)
    }

    // bind view holder
    override fun onBindViewHolder(holder : MyViewHolder, pos : Int) {
        holder.recyclerViewImage.setImageResource(imageList[pos].imageSrc)
    }

    // get size of image list
    override fun getItemCount() : Int {
        return imageList.size
    }
}