package com.example.testviewbinding.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
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
    abstract fun onSetupFragment(): Fragment?

    lateinit var layout: B


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout = bindingInflater.invoke(layoutInflater)
        setContentView(layout.root)
    }

    override fun onStart() {
        super.onStart()
        onReady()
        setupFragment()
    }

    private fun setupFragment() {
        supportFragmentManager.safeTransact {
            onSetupFragment()?.let { fragment ->
                fragmentContainerId?.let { containerId ->
                    replace(containerId, fragment)
                }
            }
        }
    }

    private inline fun FragmentManager.safeTransact(allowStateLoss: Boolean = false,
                                                    action: FragmentTransaction.() -> Unit) {
        beginTransaction().apply {
            action()
            if (!isStateSaved) commit()
            // allowStateLoss mean: https://medium.com/@jacquesgiraudel/the-fragment-is-created-then-put-into-the-back-stack-a48006784e0c
            else if (allowStateLoss) commitAllowingStateLoss()
        }
    }

    inline fun <T : Any> ifLet(vararg args: T?, closure: (List<T>) -> Unit): Unit? =
            if (args.all { it != null }) closure(args.filterNotNull()) else null
}