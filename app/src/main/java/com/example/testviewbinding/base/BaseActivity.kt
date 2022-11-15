package com.example.testviewbinding.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 *
 * @author hafizdwp
 * 04/10/2022
 **/
abstract class BaseActivity<B : ViewBinding>(
        private val bindingInflater: (LayoutInflater) -> B
) : AppCompatActivity() {

    abstract val fragmentContainerId: Int?

    abstract fun onReady()
    abstract fun onSetupFragment()

    lateinit var layout: B


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout = bindingInflater.invoke(layoutInflater)
        setContentView(layout.root)
    }

    override fun onStart() {
        super.onStart()

        onReady()
        onSetupFragment()
    }

//    override fun onBackPressed() {
//        if (supportFragmentManager.backStackEntryCount > 0) {
//            supportFragmentManager.popBackStackImmediate()
//        } else {
//            super.onBackPressed()
//        }
//    }
}