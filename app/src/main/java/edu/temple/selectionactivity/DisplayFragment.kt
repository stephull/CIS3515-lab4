package edu.temple.selectionactivity

import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

private const val ARG_PARAM1 = "par1"
private const val ARG_PARAM2 = "par2"

class DisplayFragment : Fragment()  {
    private var param1 : String? = null
    private var param2 : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val layout = inflater.inflate(R.layout.activity_display, container, false)
        val src : ImageView = layout.findViewById(R.id.selectedImage)
        val desc : TextView = layout.findViewById(R.id.selectedImageText)
        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ViewModelProvider(requireActivity()).get(MyViewModel::class.java).getMyPicture().observe(requireActivity(), {
            changeMyPicture(it)
        })
    }

    private fun changeMyPicture(picture: MyPicture) {
        picture.imageSrc
        picture.imageDesc
    }
}