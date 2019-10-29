package com.example.myapplication.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.myapplication.R
import com.example.myapplication.SampleApp

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private lateinit var skyBtn:Button
    private lateinit var blissBtn:Button
    private lateinit var escapeBtn:Button

    var listener : MainFragmentCallback? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.main_fragment, container, false)

        skyBtn = view.findViewById(R.id.sky_btn)
        blissBtn = view.findViewById(R.id.bliss_btn)
        escapeBtn = view.findViewById(R.id.escape_btn)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        skyBtn.setOnClickListener {
            viewModel.optionSelected(SampleApp.Options.Sky)
            listener?.onOptionSelected()

        }
        blissBtn.setOnClickListener {
            viewModel.optionSelected(SampleApp.Options.Bliss)
            listener?.onOptionSelected()
        }
        escapeBtn.setOnClickListener {
            viewModel.optionSelected(SampleApp.Options.Escape)
            listener?.onOptionSelected()
        }
    }

    interface MainFragmentCallback {

        fun onOptionSelected()

    }

}
