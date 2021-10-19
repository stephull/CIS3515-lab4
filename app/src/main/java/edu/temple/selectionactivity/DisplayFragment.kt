package edu.temple.selectionactivity

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

private const val ARG_PARAM1 = "par1"
private const val ARG_PARAM2 = "par2"

class DisplayFragment : Fragment()  {
    private var param1 : String? = null
    private var param2 : String? = null
    private lateinit var layout : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        layout = inflater.inflate(R.layout.activity_display, container, false)
        ViewModelProvider(requireActivity()).get(MyViewModel::class.java).getMyPicture().observe(requireActivity(), {
            //MyViewModel.setMyPicture(it)
        })
        return layout
    }
}