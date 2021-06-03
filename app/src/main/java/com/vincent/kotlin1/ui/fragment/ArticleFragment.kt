package com.vincent.kotlin1.ui.fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.vincent.kotlin1.BaseApplication
import com.vincent.kotlin1.R
import com.vincent.kotlin1.bean.Data
import com.vincent.kotlin1.synccallback.HttpCallBack
import com.vincent.kotlin1.util.HttpConstans
import com.vincent.kotlin1.util.HttpUtil
import com.vincent.kotlin1.widget.ArticleListAdapter
import java.util.ArrayList

class ArticleFragment : Fragment() {

    private lateinit var mRecyclerView : RecyclerView
    private lateinit var mLayoutManager: LinearLayoutManager
    private lateinit var mAdapter : ArticleListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.article_fragment,container,false);
    }

    override fun getView(): View? {
        return super.getView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mRecyclerView = view.findViewById(R.id.article_list)
        mLayoutManager = LinearLayoutManager(activity)
        mLayoutManager.orientation = LinearLayoutManager.VERTICAL
        mAdapter = ArticleListAdapter()
        mRecyclerView.layoutManager = mLayoutManager
        mRecyclerView.adapter = mAdapter
        loadArticleList()

    }

    private fun loadArticleList() {
        var array : ArrayList<Data> = ArrayList<Data>()
        HttpUtil.sendGet(object : HttpCallBack {
            override fun onSuccess(obj: String) {
                var jsonObject = JsonParser().parse(obj).asJsonObject
                var jobc = jsonObject.getAsJsonArray("data")
                for (jsonData in jobc){
                    val datga = Gson().fromJson(jsonData.toString(), Data :: class.java)
                    array.add(datga)
                }
                    mRecyclerView.post(Runnable {
                        mAdapter.setData(array)
                        mAdapter.notifyDataSetChanged()
                    })
            }

            override fun onFial(obj: String) {
                TODO("Not yet implemented")
            }

        }, HttpConstans.zhuanlan)
    }
}