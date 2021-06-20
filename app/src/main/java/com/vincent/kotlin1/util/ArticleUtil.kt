package com.vincent.kotlin1.util

import android.content.Context
import android.content.Intent
import com.vincent.kotlin1.ui.ArticleActivity

class ArticleUtil {


    companion object {
        public fun goLoadArticle(url: String, context: Context) {
            var intent = Intent()
            context?.let { intent.setClass(it, ArticleActivity::class.java) }
            intent.putExtra("url", url)
            context?.let { context!!.startActivity(intent) }
        }
    }

}