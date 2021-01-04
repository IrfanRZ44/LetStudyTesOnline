package id.exomatik.letstudytesonline.ui.main.main

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.graphics.Bitmap
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.gms.ads.*
import id.exomatik.letstudytesonline.base.BaseViewModel
import id.exomatik.letstudytesonline.utils.Constant
import id.exomatik.letstudytesonline.utils.checkInternetConnection

class MainViewModel : BaseViewModel() {

    @SuppressLint("SetJavaScriptEnabled")
    fun setUpWebView(web: WebView, adView: AdView, context: Context?, activity: Activity?){
        cekKoneksi(context, adView, web, activity)

        web.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                isShowLoading.value = true
                super.onPageStarted(view, url, favicon)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                isShowLoading.value = false
                super.onPageFinished(view, url)
            }
            override fun onReceivedError(
                webView: WebView,
                errorCode: Int,
                description: String,
                failingUrl: String
            ) {
                try {
                    webView.stopLoading()
                } catch (e: Exception) {
                }

                cekKoneksi(context, adView, web, activity)
            }
        }
        web.settings.loadsImagesAutomatically = true
        web.settings.javaScriptEnabled = true
        web.settings.allowFileAccess = true
        web.settings.allowContentAccess = true
        web.settings.javaScriptCanOpenWindowsAutomatically = true
        web.settings.domStorageEnabled = true

        web.settings.setSupportZoom(true)
        web.settings.displayZoomControls = true

        web.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
    }

    private fun cekKoneksi(context: Context?, adView: AdView, web: WebView, activity: Activity?){
        if(checkInternetConnection(context)){
            web.loadUrl(Constant.urlWeb)
        } else{
            val alertDialog = AlertDialog.Builder(context?:throw Exception("Unknown Error")).create()
            alertDialog.setTitle("Error")
            alertDialog.setMessage("Check your internet connection and try again.")
            alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Try Again") { dialog, _ ->
                dialog.dismiss()
                web.loadUrl(Constant.urlWeb)
            }
            alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Close") { dialog, _ ->
                dialog.dismiss()
                activity?.finish()
            }

            alertDialog.show()
        }
    }
}