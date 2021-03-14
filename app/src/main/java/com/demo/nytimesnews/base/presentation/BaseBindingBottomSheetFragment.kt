package com.demo.nytimesnews.base.presentation

import android.app.Dialog
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetDialog
import android.support.design.widget.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout


/**
 * Created by Rashida on 3/14/21.
 *
 */
abstract class BaseBindingBottomSheetFragment<B : ViewDataBinding> : BottomSheetDialogFragment() {

    protected lateinit var binding: B

    abstract val layout: Int

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
         binding = DataBindingUtil.inflate<B>(inflater, layout, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initiView()
    }
    abstract fun initiView()

}

