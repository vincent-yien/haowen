package com.vincent.kotlin1.widget

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.vincent.kotlin1.R
import com.vincent.kotlin1.bean.articleBean.ArticleBaseBean
import com.vincent.kotlin1.bean.tuijian.News
import com.vincent.kotlin1.bean.tuijian.Stories
import com.vincent.kotlin1.util.ArticleUtil
import com.vincent.kotlin1.util.ImageLoadUtil

class SlideShowPagerAdapter(mData: ArrayList<Stories>) : PagerAdapter() {

    private var mData : ArrayList<Stories> = mData

    public fun setData(data: java.util.ArrayList<Stories>){
        mData = data;
    }

    public fun addData(data: News){
        for (stories in data.getNews()){
            mData.add(stories)
        }
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return  view == `object`
    }

    override fun getCount(): Int {
        return mData.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var stories = mData[position]
        var view = LayoutInflater.from(container.context).inflate(R.layout.slide_item,container,false)
        var imageView = view.findViewById<ImageView>(R.id.slide_item_image)
        var textView = view.findViewById<TextView>(R.id.slide_item_text)
        ImageLoadUtil.displayImageCenter(imageView,stories.images[0],container.context,R.drawable.ic_launcher_background)
        textView.text = stories.title
        container.addView(view)
        view.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                ArticleUtil.goLoadArticle(mData[position].url,container.context)
            }
        })
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }
}