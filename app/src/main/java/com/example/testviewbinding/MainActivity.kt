package com.example.testviewbinding

import androidx.fragment.app.Fragment
import com.example.testviewbinding.base.BaseActivity
import com.example.testviewbinding.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun onReady() {
        layout.textTest.text = "bro"
    }

    override fun onSetupFragment(): Fragment {
        return Fragment()
    }
}