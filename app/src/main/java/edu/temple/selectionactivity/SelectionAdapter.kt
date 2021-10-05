package edu.temple.selectionactivity

import android.content.*
import android.view.*
import android.widget.*
import androidx.recyclerview.widget.*

class SelectionAdapter (_context : Context, _imageList : ArrayList<MyPicture>) : RecyclerView.Adapter<SelectionAdapter.MyViewHolder>() {
    // declare variables
    private val context = _context
    private val imageList = _imageList

    interface OnItemClickListener {
        fun onItemClick(pos : Int)
    }

    private lateinit var myListener : OnItemClickListener
    fun setOnItemClickListener(listener : OnItemClickListener) {
        myListener = listener
    }

    // view holder class
    class MyViewHolder(view: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(view) {
        val recycleViewImage: ImageView = view.findViewById(R.id.recyclerViewImage)
        init {
            view.setOnClickListener { listener.onItemClick(adapterPosition) }
        }
    }

    // create view holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val holderItem = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview, parent, false)
        return MyViewHolder(holderItem, myListener)
    }

    // bind view holder
    override fun onBindViewHolder(holder: MyViewHolder, pos: Int) {
        holder.recycleViewImage.setImageResource(imageList[pos].imageSrc)
    }

    // return the size of image list
    override fun getItemCount(): Int {
        return imageList.size
    }
}