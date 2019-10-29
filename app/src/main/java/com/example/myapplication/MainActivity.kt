package com.example.myapplication

import android.Manifest
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.myapplication.ui.detail.DetailFragment
import com.example.myapplication.ui.main.MainFragment
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.example.myapplication.services.ServiceAPI
import com.example.myapplication.services.ServiceClient


class MainActivity : AppCompatActivity(), MainFragment.MainFragmentCallback {

    companion object {
        private const val REQUEST_ID_MULTIPLE_PERMISSIONS = 101
    }

    private lateinit var mainFragment:MainFragment
    private lateinit var detailFragment:DetailFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        mainFragment = supportFragmentManager.findFragmentById(R.id.main_fragment) as MainFragment
        mainFragment.listener = this
        detailFragment = supportFragmentManager.findFragmentById(R.id.detail_fragment) as DetailFragment

        if (savedInstanceState == null) {
            start()
        }
    }

    fun start() {
        SampleApp.instance.api = ServiceClient.client!!.create(ServiceAPI::class.java)
    }

    override fun onOptionSelected() {
        detailFragment.refresh()
    }

}
