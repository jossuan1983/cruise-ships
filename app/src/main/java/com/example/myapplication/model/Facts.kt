package com.example.myapplication.model

import com.google.gson.annotations.SerializedName

class Facts {

    @SerializedName("passengerCapacity")
    var passengerCapacity: Int? = null

    @SerializedName("crew")
    var crew: Int? = null

    @SerializedName("inauguralDate")
    var inauguralDate: String? = null

}