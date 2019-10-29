package com.example.myapplication

import android.app.Application
import com.example.myapplication.services.ServiceAPI

class SampleApp : Application() {

    enum class Options(val value:String) {
        None("NONE"),
        Bliss("BLISS"),
        Escape("ESCAPE"),
        Sky("SKY"),
    }

    companion object {
        lateinit var instance: SampleApp
    }

    init {
        instance = this
    }

    var selectedOption = Options.None

    var api: ServiceAPI? = null
}