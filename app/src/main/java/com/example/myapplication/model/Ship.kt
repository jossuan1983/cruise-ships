package com.example.myapplication.model

import com.google.gson.annotations.SerializedName



class Ship  {

    @SerializedName("shipName")
    var shipName: String? = null

    @SerializedName("facts")
    var facts: Facts? = null

}