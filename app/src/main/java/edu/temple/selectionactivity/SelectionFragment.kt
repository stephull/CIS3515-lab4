package edu.temple.selectionactivity

import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SelectionFragment : Fragment() {
    private lateinit var mainView : RecyclerView
    private lateinit var vmp : ViewModelProvider
    private lateinit var newMyPicture : ArrayList<MyPicture>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        newMyPicture = arguments?.getParcelableArrayList("MyPictureList")!!
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val layout = inflater.inflate(R.layout.activity_selection, container, false)
        mainView = RecyclerView(requireActivity())
        mainView.layoutManager = GridLayoutManager(requireContext(), 3)

        val adapter = SelectionAdapter(requireContext(), newMyPicture)
        mainView.adapter = adapter
        adapter.setOnItemClickListener(object: SelectionAdapter.OnItemClickListener {
            override fun onItemClick(pos: Int) {
                val item = newMyPicture[pos]
            }
        })

        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vmp = ViewModelProvider(requireActivity())
        changeMyPicture(newMyPicture)
    }

    private fun changeMyPicture(pos : ArrayList<MyPicture>?) {
        if (pos != null) {
            //mainView.setSelection(pos)
        }
    }

    companion object {
        fun newInstance (pictures : ArrayList<MyPicture>) : SelectionFragment {
            return SelectionFragment().apply {
                Bundle().apply {
                    putParcelableArrayList("MyPictureList", pictures)
                }
            }
        }
    }
}