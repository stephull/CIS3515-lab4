package edu.temple.selectionactivity

import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class DisplayFragment : Fragment()  {
    private lateinit var src : ImageView
    private lateinit var desc : TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val layout = inflater.inflate(R.layout.activity_display, container, false)
        src = layout.findViewById(R.id.selectedImage)
        desc = layout.findViewById(R.id.selectedImageText)
        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ViewModelProvider(requireActivity()).get(MyViewModel::class.java).getMyPicture().observe(requireActivity(), {
            changeMyPicture(it)
        })
    }

    private fun changeMyPicture(picture: MyPicture) {
        src.setImageResource(picture.imageSrc)
        desc.text = picture.imageDesc
    }
}