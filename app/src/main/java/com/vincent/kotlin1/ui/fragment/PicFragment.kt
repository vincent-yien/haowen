package com.vincent.kotlin1.ui.fragment

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.vincent.kotlin1.R
import com.vincent.kotlin1.bean.pictureBean.Picture
import com.vincent.kotlin1.synccallback.HttpCallBack
import com.vincent.kotlin1.util.HttpConstans
import com.vincent.kotlin1.util.HttpUtil
import com.vincent.kotlin1.widget.PictureAdapter

class PicFragment : Fragment() {

    private var mRecyclerView : RecyclerView ?= null
    private var mLayoutManager : StaggeredGridLayoutManager ?= null
    private var mAdapter : PictureAdapter ?= null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.pic_fragment, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mRecyclerView = view.findViewById(R.id.pic_list)
        mLayoutManager = StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)
        mAdapter = PictureAdapter()
        mRecyclerView?.layoutManager = mLayoutManager
        mRecyclerView?.adapter = mAdapter
    }

    override fun onStart() {
        super.onStart()
        loadPicture(0)
    }

    override fun getView(): View? {
        return super.getView()
    }

    private fun loadPicture(position : Int){
        HttpUtil.sendGet(object : HttpCallBack {
            override fun onSuccess(obj: String) {
                if(!TextUtils.isEmpty(obj)){
                    var pictures = ArrayList<Picture>()
                    var jsonArray = JsonParser().parse(obj).asJsonArray
                    for (json in jsonArray){
                        pictures.add(Gson().fromJson(json,Picture::class.java))
                        mRecyclerView?.post(Runnable {
                            mAdapter?.setData(pictures)
                            mAdapter?.notifyDataSetChanged()
                        })
                    }
                }
            }

            override fun onFial(obj: String) {
            }

        },HttpConstans.PICTURE);
    }



}