package com.vincent.kotlin1.ui

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity(){

    private var mActivitys  = ArrayList<Activity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun addActivity(act :Activity){
        mActivitys.add(act)
    }

    fun removeActivity(act : Activity){
        mActivitys.remove(act)
    }

    override fun finish() {
        super.finish()
    }

    fun getActivity() : Activity{
        return mActivitys[mActivitys.size-1]
    }





}