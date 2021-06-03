package com.vincent.kotlin1

import android.app.Application

class BaseApplication : Application() {

    companion object {
        var sInstance : BaseApplication  ?= null

        public fun getInstance(): BaseApplication? {
            return sInstance
        }
    }

    override fun onCreate() {
        super.onCreate()
        sInstance = this
    }

}