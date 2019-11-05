package com.deevd.securestorage.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Hein Htet on 2019-11-03.
 */

@Parcelize
data class UserItem(
    var id : String,
    var type :String,
    var name : String,
    var ppu : Float,
    var batters : BatterData,
    var topping  :List<Top>
) : Parcelable

@Parcelize
data class BatterData(
    var batter : List<Batter>
) : Parcelable

@Parcelize
data class Batter (
    var id : String,
    var type :String
):Parcelable


@Parcelize
data class Top (
    var id : String,
    var type: String
) : Parcelable

