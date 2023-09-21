package com.example.mega

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.webkit.GeolocationPermissions
import android.webkit.PermissionRequest
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.mega.WebChromeClientCustomPoster.WebChromeClientCustomPoster


class MainActivity : Activity() {
    val PERMISSION_REQUEST_CODE = 123
    lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)

        // WebView 설정 가져오기
        val webSettings: WebSettings = webView.settings

        // JavaScript를 활성화
        webSettings.javaScriptEnabled = true
        webSettings.setGeolocationEnabled(true)
        webSettings.javaScriptCanOpenWindowsAutomatically = true
        webSettings.setSupportMultipleWindows(false)
        webSettings.setSupportZoom(false)
        webSettings.displayZoomControls = false
        webSettings.builtInZoomControls = false

        // WebViewClient 설정 (웹 페이지를 WebView 안에서 열도록 함)
        webView.webViewClient = WebViewClient()

        webView.webChromeClient = WebChromeClient()
        webView.webChromeClient = WebChromeClientCustomPoster()

        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                // 웹페이지 로딩이 완료되면 권한 확인 및 요청
                checkPermissions()
            }
        }

        webView.webChromeClient = object : WebChromeClient() {
            override fun onGeolocationPermissionsShowPrompt(
                origin: String,
                callback: GeolocationPermissions.Callback
            ) {
                // 위치 권한 요청 대화 상자를 표시하고 사용자의 응답을 처리
                ActivityCompat.requestPermissions(
                    this@MainActivity,
                    arrayOf(Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION),
                    PERMISSION_REQUEST_CODE
                )

                // 권한 요청 결과를 WebView에 전달
                callback.invoke(origin, true, false)
            }

            override fun onPermissionRequest(request : PermissionRequest) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    request.grant(request.getResources());
                }
            }
        }

        webView.loadUrl("https://mega-user.vercel.app/")
    }

    private fun checkPermissions() {
        // Android 6.0 이상 버전에서만 권한 체크가 필요합니다.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val permissions =
                arrayOf(Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION)
            var allPermissionsGranted = true
            for (permission in permissions) {
                if (ContextCompat.checkSelfPermission(this, permission)
                    != PackageManager.PERMISSION_GRANTED
                ) {
                    allPermissionsGranted = false
                    break
                }
            }
            if (!allPermissionsGranted) {
                // 하나 이상의 권한이 거부되었을 경우 권한 요청
                ActivityCompat.requestPermissions(this, permissions, PERMISSION_REQUEST_CODE)
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == PERMISSION_REQUEST_CODE) {
            var allPermissionsGranted = true
            for (grantResult in grantResults) {
                if (grantResult != PackageManager.PERMISSION_GRANTED) {
                    allPermissionsGranted = false
                    break
                }
            }
            if (allPermissionsGranted) {
                // 모든 권한이 승인되었을 경우 작업 수행
                Toast.makeText(this, "모든 권한이 허용되었습니다.", Toast.LENGTH_SHORT).show()
            } else {
                // 하나 이상의 권한이 거부되었을 경우 사용자에게 메시지 표시 또는 다른 작업 수행
                Toast.makeText(this, "권한이 거부되었습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onBackPressed() {
        // 뒤로가기 기능 구현

        val myWebView: WebView = findViewById(R.id.webView)
        if(myWebView.canGoBack()){
            myWebView.goBack()
        }else{
            super.onBackPressed()
        }
    }
}