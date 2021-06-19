package com.vincent.kotlin1.widget

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.vincent.kotlin1.BaseApplication
import com.vincent.kotlin1.R
import com.vincent.kotlin1.bean.articleBean.ArticleBaseBean
import com.vincent.kotlin1.bean.tuijian.News
import com.vincent.kotlin1.bean.tuijian.Stories
import com.vincent.kotlin1.util.ImageLoadUtil
import org.w3c.dom.Text

class SlideShowPagerAdapter(mData: ArrayList<ArticleBaseBean>) : PagerAdapter() {

    private var mData : ArrayList<ArticleBaseBean> = mData

    public fun setData(data: ArrayList<ArticleBaseBean>){
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
        var stories = mData[position] as Stories
        var view = LayoutInflater.from(container.context).inflate(R.layout.slide_item,container,false)
        var imageView = view.findViewById<ImageView>(R.id.slide_item_image)
        var textView = view.findViewById<TextView>(R.id.slide_item_text)
//        Glide.with(container.context).load(stories.images[0]).into(imageView)
        ImageLoadUtil.displayImageCenter(imageView,stories.images[0],container.context,R.drawable.ic_launcher_background)
        textView.text = stories.title
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }
}