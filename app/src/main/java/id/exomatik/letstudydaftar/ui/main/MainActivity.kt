package id.exomatik.letstudydaftar.ui.main

import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import id.exomatik.letstudydaftar.R
import id.exomatik.letstudydaftar.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun getLayoutResource(): Int = R.layout.activity_main
    private var exit = false

    @Suppress("DEPRECATION")
    override fun myCodeHere() {
        NavHostFragment.create(R.navigation.main_nav)
        viewParent.systemUiVisibility = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }

    override fun onBackPressed() {
        if (exit) {
            finish()
            return
        } else {
            Toast.makeText(this, "Tekan Cepat 2 Kali untuk Keluar", Toast.LENGTH_LONG).show()
            exit = true

            object : CountDownTimer(2000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                }

                override fun onFinish() {
                    exit = false
                }
            }.start()
        }
    }
}
