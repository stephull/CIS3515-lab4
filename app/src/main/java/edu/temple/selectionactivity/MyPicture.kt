package edu.temple.selectionactivity

import android.os.Parcel
import android.os.Parcelable

data class MyPicture(val imageDesc : String? , val imageSrc : Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(imageDesc)
        parcel.writeInt(imageSrc)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MyPicture> {
        override fun createFromParcel(parcel: Parcel): MyPicture {
            return MyPicture(parcel)
        }

        override fun newArray(size: Int): Array<MyPicture?> {
            return arrayOfNulls(size)
        }
    }

}