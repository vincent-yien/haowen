package com.vincent.kotlin1.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.vincent.kotlin1.R
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
        mLayoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        mAdapter = PictureAdapter()
        mRecyclerView?.layoutManager = mLayoutManager
        mRecyclerView?.adapter = mAdapter
    }

    override fun getView(): View? {
        return super.getView()
    }



}