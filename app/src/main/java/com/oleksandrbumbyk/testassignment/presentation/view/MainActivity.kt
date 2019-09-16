package com.oleksandrbumbyk.testassignment.presentation.view

import android.os.Bundle
import com.oleksandrbumbyk.testassignment.R
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
