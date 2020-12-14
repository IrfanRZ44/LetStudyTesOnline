package id.exomatik.letstudytesonline.ui.main.splash

import android.Manifest
import android.content.pm.PackageManager
import android.os.CountDownTimer
import androidx.core.app.ActivityCompat
import androidx.navigation.fragment.findNavController
import id.exomatik.letstudytesonline.R
import id.exomatik.letstudytesonline.base.BaseFragment
import id.exomatik.letstudytesonline.utils.showSnackbar

class SplashFragment : BaseFragment() {
    override fun getLayoutResource(): Int = R.layout.fragment_splash

    override fun myCodeHere() {
        navigate()
        checkStoragePermission()
    }

    private fun checkStoragePermission(): Boolean {
        return if (activity?.let {
                ActivityCompat.checkSelfPermission(
                    it,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                )
            } != PackageManager.PERMISSION_GRANTED
        ) {
            showSnackbar(v, "Mohon izinkan akses terlebih dulu")

            activity?.let {
                ActivityCompat.requestPermissions(
                    it,
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    100
                )
            }
            false
        } else {
            true
        }
    }

    private fun navigate(){
        object : CountDownTimer(2000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
            }

            override fun onFinish() {
                findNavController().navigate(R.id.mainFragment)
            }
        }.start()
    }
}