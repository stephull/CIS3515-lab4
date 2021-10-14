package edu.temple.selectionactivity

import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class SelectionFragment : Fragment() {
    private lateinit var mainView : RecyclerView
    private lateinit var instructText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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