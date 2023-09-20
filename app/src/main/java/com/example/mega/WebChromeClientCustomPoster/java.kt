package com.example.mega.WebChromeClientCustomPoster

import android.graphics.Bitmap
import android.os.Build
import android.webkit.PermissionRequest
import android.webkit.WebChromeClient


class WebChromeClientCustomPoster : WebChromeClient() {
    override fun getDefaultVideoPoster(): Bitmap? {
        return Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888)
    }

    override fun onPermissionRequest(request: PermissionRequest) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            request.grant(request.resources)
        }
    }
}