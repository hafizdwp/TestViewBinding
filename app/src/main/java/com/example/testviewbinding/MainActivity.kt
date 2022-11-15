package com.example.testviewbinding

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.widget.AppCompatImageButton
import androidx.core.view.children
import com.example.testviewbinding.base.BaseActivity
import com.example.testviewbinding.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override val fragmentContainerId: Int?
        get() = layout.container.fragmentContainer.id

    val fragments = arrayOf(
            MainFragment(),
            MainSearchFragment()
    )

    override fun onReady() {
//        layout.toolbar.apply {
//            inflateMenu(R.menu.main)
//
//            title = "test"
//            setNavigationIcon(R.drawable.ic_arrow_left)
//            children.forEach {
//                (it as? AppCompatImageButton)?.imageTintList =
//                        ColorStateList.valueOf(Color.parseColor("#b22222"))
//                it.refreshDrawableState()
//            }
//            setNavigationOnClickListener {
//                onBackPressed()
//            }
//        }
    }

    override fun onSetupFragment() {
        supportFragmentManager.beginTransaction().apply {
            fragments.forEach { frg ->
                if (!frg.isAdded) {
                    add(fragmentContainerId!!, frg)
                    hide(frg)
                }
            }

            show(fragments[0])
        }.commit()
    }

    fun openSearchFragment() {
        supportFragmentManager.beginTransaction().apply {
            addToBackStack(null)
            show(fragments[1])
        }.commit()
    }
}