package com.example.testviewbinding

import androidx.fragment.app.Fragment
import com.example.testviewbinding.base.BaseActivity
import com.example.testviewbinding.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override val fragmentContainerId: Int?
        get() = layout.container.fragmentContainer.id


    override fun onReady() {

    }

    override fun onSetupFragment(): Fragment {
        return MainFragment()
    }

}