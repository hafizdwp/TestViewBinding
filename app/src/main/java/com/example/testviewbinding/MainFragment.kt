package com.example.testviewbinding

import com.example.testviewbinding.base.BaseFragment
import com.example.testviewbinding.databinding.FragmentMainBinding

/**
 *
 * @author hafizdwp
 * 04/10/2022
 **/
class MainFragment : BaseFragment<MainActivity, FragmentMainBinding>(FragmentMainBinding::inflate) {

    override fun onViewReady() {
        layout.toolbar.apply {
            setNavigationIcon(R.drawable.ic_arrow_left)
            setNavigationOnClickListener {
                requireActivity().onBackPressed()
            }
            setTitle("asd")
        }
    }
}