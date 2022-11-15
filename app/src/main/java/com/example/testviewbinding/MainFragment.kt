package com.example.testviewbinding

import android.content.res.ColorStateList
import android.graphics.Color
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageButton
import androidx.core.view.children
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
            children.forEach {
                (it as? AppCompatImageButton)?.imageTintList =
                        ColorStateList.valueOf(Color.parseColor("#b22222"))
                it.refreshDrawableState()
            }
            setNavigationOnClickListener {
                requireActivity().onBackPressed()
            }
            title = "Alat Bantu"
            inflateMenu(R.menu.main)
            setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.search -> {
                        mActivity.openSearchFragment()
                        true
                    }

                    else -> {
                        false
                    }
                }
            }
        }
        layout.btnTest.setOnClickListener {
            layout.toolbar.menu.getItem(0).setIcon(R.drawable.ic_x)
        }

        mHandleBackPressed.enable()
    }

    override fun handleBackPressed() {
        if (obpcount > 3) {
            mHandleBackPressed.disable()
            mActivity.onBackPressed()
        } else {
            obpcount++
            toast("back $obpcount")
        }
    }

    var toast: Toast? = null
    fun toast(msg: String) {
        toast?.cancel()
        toast = Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT)
        toast?.show()
    }

    var obpcount = 0
}