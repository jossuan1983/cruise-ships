package com.example.myapplication.ui.detail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import com.example.myapplication.R
import com.example.myapplication.model.Ship


class DetailFragment : Fragment() {

    companion object {
        fun newInstance() = DetailFragment()
    }

    private lateinit var viewModel: DetailViewModel

    private lateinit var shipNameTxt:TextView

    private lateinit var capacityTxt:TextView
    private lateinit var crewTxt:TextView
    private lateinit var inaugDateTxt:TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view = inflater.inflate(com.example.myapplication.R.layout.detail_fragment, container, false)

        shipNameTxt = view.findViewById(R.id.ship_name_txt)
        capacityTxt = view.findViewById(R.id.pass_cap_txt)
        crewTxt = view.findViewById(R.id.crew_txt)
        inaugDateTxt = view.findViewById(R.id.inaug_date_txt)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)

        viewModel.selectedShip.observe(this, Observer<Ship> { item ->
            shipNameTxt.text = item.shipName
            capacityTxt.text = item.facts!!.passengerCapacity.toString()
            crewTxt.text = item.facts!!.crew.toString()
            inaugDateTxt.text = item.facts!!.inauguralDate
        })
    }

    fun refresh() {
        viewModel.requestDetails()
    }

}
