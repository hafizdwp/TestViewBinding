package com.example.testviewbinding.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 *
 * @author hafizdwp
 * 04/10/2022
 **/
abstract class BaseFragment<ACTIVITY : AppCompatActivity, BINDING : ViewBinding>(
        private val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> BINDING
) : Fragment() {

    lateinit var mActivity: ACTIVITY
    lateinit var mContext: Context
    lateinit var layout: BINDING

    abstract fun onViewReady()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
        mActivity = requireActivity() as ACTIVITY
        mContext = requireContext()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        layout = bindingInflater.invoke(inflater, container, false)
        return layout.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onViewReady()
    }

    open fun handleBackPressed() {

    }

    val mHandleBackPressed = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            this@BaseFragment.handleBackPressed()
        }
    }

    fun OnBackPressedCallback.enable() {
        mActivity.onBackPressedDispatcher.addCallback(viewLifecycleOwner, this)
    }

    fun OnBackPressedCallback.disable() {
        this.isEnabled = false
    }
}