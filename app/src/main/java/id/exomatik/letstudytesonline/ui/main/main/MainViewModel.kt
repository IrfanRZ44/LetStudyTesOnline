package id.exomatik.letstudytesonline.ui.main.main

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import id.exomatik.letstudytesonline.base.BaseViewModel
import id.exomatik.letstudytesonline.utils.Constant

class MainViewModel : BaseViewModel() {

    fun setUpAdmob(context: Context?, adView: AdView){
        MobileAds.initialize(context) {}

        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
    }

    @SuppressLint("SetJavaScriptEnabled")
    fun setUpWebView(web: WebView){
        web.loadUrl(Constant.urlWeb)

        web.webViewClient = WebViewClient()
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
}