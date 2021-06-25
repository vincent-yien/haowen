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
        if(act != null){
            mActivitys.add(act)
        }
    }

    fun removeActivity(act : Activity){
        if(act != null){
            mActivitys.remove(act)
        }
    }

    override fun finish() {
        super.finish()
        for (act in mActivitys){
            act.finish()
        }
        mActivitys.clear()
    }

    fun getActivity() : Activity{
        return mActivitys.get(mActivitys.size-1)
    }





}