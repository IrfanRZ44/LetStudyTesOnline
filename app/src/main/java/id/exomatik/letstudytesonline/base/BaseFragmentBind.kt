package id.exomatik.letstudytesonline.base

import android.view.View
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseFragmentBind<B : ViewDataBinding> : Fragment() {
    protected lateinit var bind: B
    protected abstract fun getLayoutResource(): Int
    protected abstract fun myCodeHere()
    protected var savedInstanceState: Bundle? = null

    override fun onCreateView(paramLayoutInflater: LayoutInflater, paramViewGroup: ViewGroup?, paramBundle: Bundle?): View? {
        bind = DataBindingUtil.inflate(layoutInflater, getLayoutResource(), paramViewGroup, false)

        savedInstanceState = paramBundle
        myCodeHere()
        return bind.root
    }

}