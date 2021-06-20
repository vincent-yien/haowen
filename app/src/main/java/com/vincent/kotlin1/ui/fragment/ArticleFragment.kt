package com.vincent.kotlin1.ui.fragment
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.vincent.kotlin1.BaseApplication
import com.vincent.kotlin1.R
import com.vincent.kotlin1.bean.tuijian.News
import com.vincent.kotlin1.bean.tuijian.Stories
import com.vincent.kotlin1.synccallback.HttpCallBack
import com.vincent.kotlin1.ui.ArticleActivity
import com.vincent.kotlin1.util.HttpConstans
import com.vincent.kotlin1.util.HttpUtil
import com.vincent.kotlin1.widget.ArticleListAdapter
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ArticleFragment : Fragment(){

    private lateinit var mRecyclerView : RecyclerView
    private lateinit var mLayoutManager: LinearLayoutManager
    private lateinit var mAdapter : ArticleListAdapter
    private var mViewPager : ViewPager ?= null
    var mArray : ArrayList<Any> = ArrayList()
    private var mEndIndex = 0
    private var mAllIndex = 0
    var calendar = Calendar.getInstance();

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        calendar.setTime(Date());
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
        mAdapter = ArticleListAdapter(view.context)
        mRecyclerView.layoutManager = mLayoutManager
        mRecyclerView.adapter = mAdapter

        mViewPager = view.findViewById(R.id.slideshow)
        loadSlideList()
        mRecyclerView.postDelayed(Runnable { kotlin.run {  loadArticleList(HttpConstans.NEWSDATE+getDate(false))} },2)

        mRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            @Synchronized override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE){
                    BaseApplication.getInstance()?.let { Glide.with(it).resumeRequests() }
                }else if(newState == RecyclerView.SCROLL_STATE_DRAGGING || newState == RecyclerView.SCROLL_STATE_SETTLING){
                    BaseApplication.getInstance()?.let { Glide.with(it).pauseAllRequests() }
                    var layoutManager : LinearLayoutManager = recyclerView.layoutManager as LinearLayoutManager
                    if (layoutManager.itemCount - layoutManager.findLastVisibleItemPosition() <= 1){
                        loadArticleList(HttpConstans.NEWSDATE+getDate(true))
                    }
                }
            }
        })
    }

    @Synchronized private fun loadArticleList(url : String) {

        HttpUtil.sendGet(object : HttpCallBack {
            override fun onSuccess(obj: String) {
                var jsonObject = JsonParser().parse(obj).asJsonObject
                var jobc = jsonObject.getAsJsonArray("stories")
                var array : ArrayList<Any> = ArrayList()
                for (jsonData in jobc){
                        val datga = Gson().fromJson(jsonData.toString(), Stories::class.java)
                        datga.type = 0
                        array.add(datga)
                    mAllIndex ++
                }
                mRecyclerView.post(Runnable {
                    kotlin.run {
                        mAdapter.addData(array)
                        mAdapter.notifyDataSetChanged()
                    }
                })
            }

            override fun onFial(obj: String) {

            }

        }, url)

    }

    private fun loadSlideList() {

        HttpUtil.sendGet(object : HttpCallBack {
            override fun onSuccess(obj: String) {
                var jsonObject = JsonParser().parse(obj).asJsonObject
                var jobc = jsonObject.getAsJsonArray("stories")
                var news : News = News()
                for (jsonData in jobc){
                    val datga = Gson().fromJson(jsonData.toString(), Stories::class.java)
                    datga.type = 1
                    news.addData(datga)
                }
                mRecyclerView.post(Runnable {
                    kotlin.run {
                        mAdapter.setSlide(news)
                        mAdapter.notifyDataSetChanged()
                    }
                })
            }

            override fun onFial(obj: String) {
                TODO("Not yet implemented")
            }

        }, HttpConstans.NEWS)

    }

    private fun getDate(isAdd : Boolean) : String {

       //new一个Calendar类,把Date放进去
        var sdf: SimpleDateFormat = SimpleDateFormat("yyyyMMdd")
        if(isAdd) {
            calendar.add(Calendar.DATE, -1);
            return sdf.format(calendar.time)
        }else{
            return sdf.format(Date())
        }
    }

}