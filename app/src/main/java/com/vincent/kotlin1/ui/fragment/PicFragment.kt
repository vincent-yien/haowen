package com.vincent.kotlin1.ui.fragment

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.vincent.kotlin1.BaseApplication
import com.vincent.kotlin1.R
import com.vincent.kotlin1.bean.pictureBean.Picture
import com.vincent.kotlin1.synccallback.HttpCallBack
import com.vincent.kotlin1.util.HttpConstans
import com.vincent.kotlin1.util.HttpUtil
import com.vincent.kotlin1.widget.PictureAdapter

class PicFragment : Fragment() {

    private var mRecyclerView : RecyclerView ?= null
    private var mLayoutManager : GridLayoutManager ?= null
    private var mAdapter : PictureAdapter ?= null
    private var mPositon = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.pic_fragment, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mRecyclerView = view.findViewById(R.id.pic_list)
        mLayoutManager = GridLayoutManager(view.context,3)
        mAdapter = PictureAdapter()
        mRecyclerView?.layoutManager = mLayoutManager
        mRecyclerView?.adapter = mAdapter
        mRecyclerView?.setOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE){
                    BaseApplication.getInstance()?.let { Glide.with(it).resumeRequests() }
                }else if(newState == RecyclerView.SCROLL_STATE_DRAGGING || newState == RecyclerView.SCROLL_STATE_SETTLING){
                    BaseApplication.getInstance()?.let { Glide.with(it).pauseAllRequests() }
                    var layoutManager : GridLayoutManager = recyclerView.layoutManager as GridLayoutManager
                    var item =  layoutManager.findLastVisibleItemPosition()
                    if (layoutManager.itemCount - item <= 20){
                        loadPicture(mPositon++)
                    }
                }
            }
        })
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
                    }
                    mRecyclerView?.post(Runnable {
                        mAdapter?.addData(pictures)
                        mAdapter?.notifyDataSetChanged()
                    })
                }
            }

            override fun onFial(obj: String) {
            }

        },String.format(HttpConstans.PICTURE,mPositon));
    }



}