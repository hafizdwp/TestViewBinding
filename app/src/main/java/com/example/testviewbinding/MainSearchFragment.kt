package com.example.testviewbinding

import com.example.testviewbinding.base.BaseFragment
import com.example.testviewbinding.databinding.FragmentMainSearchBinding

/**
 *
 * @author hafizdwp
 * 05/10/2022
 **/
class MainSearchFragment : BaseFragment<MainActivity, FragmentMainSearchBinding>(FragmentMainSearchBinding::inflate) {

    override fun onViewReady() {
        layout.toolbar.apply {

        }
    }
}