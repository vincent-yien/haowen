package com.vincent.kotlin1.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.webkit.WebChromeClient
import android.webkit.WebView
import com.vincent.kotlin1.R
import kotlinx.android.synthetic.main.activity_acticle.*

class ArticleActivity : BaseActivity(){

    private var webView : WebView ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadData(intent)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        if (intent != null) {
            loadData(intent)
        }
    }

    fun loadData(intent : Intent){
        var url = intent.getStringExtra("url")
        Log.d("RANWS","utl:"+url)
        if (webView == null){
            webView = findViewById(R.id.article)
        }
        if (url != null) {
            webView?.loadUrl(url)
        }

    }

}