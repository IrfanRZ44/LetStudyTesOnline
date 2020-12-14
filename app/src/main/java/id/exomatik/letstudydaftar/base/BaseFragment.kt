package id.exomatik.letstudydaftar.base

import android.view.View
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup

abstract class BaseFragment : Fragment() {
    protected lateinit var v : View
    protected abstract fun getLayoutResource(): Int
    protected abstract fun myCodeHere()

    override fun onCreateView(paramLayoutInflater: LayoutInflater, paramViewGroup: ViewGroup?, paramBundle: Bundle?): View? {
        v = paramLayoutInflater.inflate(getLayoutResource(), paramViewGroup, false)

        myCodeHere()
        return v
    }
}