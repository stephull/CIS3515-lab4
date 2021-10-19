package edu.temple.selectionactivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    private var display = MutableLiveData<MyPicture>()

    fun getMyPicture() : LiveData<MyPicture> {
        return display
    }

    fun setMyPicture(_display : MyPicture) {
        display.value = _display
    }
}