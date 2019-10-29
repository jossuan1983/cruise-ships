package com.example.myapplication.ui.main

import androidx.lifecycle.ViewModel
import com.example.myapplication.SampleApp


class MainViewModel : ViewModel() {

    fun optionSelected(option: SampleApp.Options) {
        SampleApp.instance.selectedOption = option
    }
    // TODO: Implement the ViewModel
}
