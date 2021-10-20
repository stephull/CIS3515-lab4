package edu.temple.selectionactivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    val modelItem = MutableLiveData<MyPicture>()
    fun getMyPicture() : LiveData<MyPicture> = modelItem
    fun setMyPicture(newItem : MyPicture) {
        modelItem.value = newItem
    }
}