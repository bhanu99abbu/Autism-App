package com.bhanu.autism

import android.os.Parcel
import android.os.Parcelable


data class Autism(
    val poster: Int = 0,
    val name: String,
    val price: String,
    val rating: String,
    val size: String,
    val description: String = "A letter is a type of grapheme, which is a functional unit in a writing system: " +
            "a letter (or group of letters) represents visually a phoneme (a unit of sound that can distinguish" +
            " one word from another in a particular language)."
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!

    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(poster)
        parcel.writeString(name)
        parcel.writeString(price)
        parcel.writeString(rating)
        parcel.writeString(size)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Autism> {
        override fun createFromParcel(parcel: Parcel): Autism {
            return Autism(parcel)
        }

        override fun newArray(size: Int): Array<Autism?> {
            return arrayOfNulls(size)
        }
    }
}