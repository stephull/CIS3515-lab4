package edu.temple.selectionactivity

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SelectionFragment : Fragment() {
    private lateinit var adapter : SelectionAdapter
    private lateinit var viewModel : MyViewModel
    private lateinit var myPictureList : ArrayList<MyPicture>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myPictureList = arguments?.getParcelableArrayList<MyPicture>("MyPictureList") as ArrayList<MyPicture>
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val layout = inflater.inflate(R.layout.activity_selection, container, false)
        val mainView : RecyclerView = layout.findViewById(R.id.imageMenu)
        mainView.layoutManager = GridLayoutManager(requireContext(), 3)

        adapter = SelectionAdapter(requireContext(), myPictureList)
        mainView.adapter = adapter
        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)
        adapter.setOnItemClickListener(object: SelectionAdapter.OnItemClickListener {
            override fun onItemClick(pos: Int) {
                val item = myPictureList[pos]
                // do ViewModelProvider stuff here
            }
        })
    }

    // is this necessary???
    private fun changeMyPicture(picture : MyPicture?) {
        if (picture != null) {
            viewModel.setMyPicture(picture)
        }
    }

    companion object {
        fun newInstance (pictures : ArrayList<MyPicture>) : SelectionFragment {
            val fragment = SelectionFragment()
            val bundle = Bundle()
            bundle.putParcelableArrayList("MyPictureList", pictures)
            fragment.arguments = bundle
            return fragment
        }
    }
}