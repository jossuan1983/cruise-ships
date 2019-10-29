package com.example.myapplication.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.SampleApp
import com.example.myapplication.model.Ship
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel : ViewModel() {

    var selectedShip = MutableLiveData<Ship>()

    fun requestDetails () {
        var call:Call<Ship>? = when(SampleApp.instance.selectedOption) {
            SampleApp.Options.None -> null
            SampleApp.Options.Bliss -> SampleApp.instance.api!!.doGetBlissDetails()
            SampleApp.Options.Escape -> SampleApp.instance.api!!.doGetEscapeDetails()
            SampleApp.Options.Sky -> SampleApp.instance.api!!.doGetSkyDetails()
        } ?: return
        call!!.enqueue(object : Callback<Ship> {
            override fun onResponse(call: Call<Ship>, response: Response<Ship>) {
                selectedShip.value = response.body()
            }

            override fun onFailure(call: Call<Ship>, t: Throwable) {
                call.cancel()
            }
        })
    }


}
