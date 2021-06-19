package com.vincent.kotlin1.widget

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.vincent.kotlin1.R
import com.vincent.kotlin1.bean.articleBean.ArticleBaseBean
import com.vincent.kotlin1.bean.tuijian.News
import com.vincent.kotlin1.bean.tuijian.Stories

private const val SLIDE = 0;
private const val NORMAL = 1;
private const val UNKNOW = -1;
class ArticleListAdapter(context : Context) : RecyclerView.Adapter<ArticleListAdapter.BaseArticItemHolder>() {

    private var mContext : Context ?= null
    private var mData : ArrayList<Any> = ArrayList()
    private var mSlideHolder : ArticSlideHolder ?= null
    companion object {
        private var mSelectPointIndex = 0
    }

    init {
        mContext = context
    }

    fun setData(data: ArrayList<Any>){
        mData = data
    }

    fun setSlide(slide : News){
        mData.add(0,slide)
    }

    fun addData(data: ArrayList<Any>?){
        if (data != null) {
            mData.addAll(data)
        }
    }

    override fun getItemViewType(position: Int): Int {
        var data = mData[position]
        if(data is Stories){
            data as Stories
            return NORMAL
        }else if(data is News){
            return SLIDE
        }
        return UNKNOW;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : BaseArticItemHolder {
        return if(viewType == SLIDE){
//            if(mSlideHolder == null){
                val view = LayoutInflater.from(parent.context).inflate(R.layout.article_slide,parent,false)
                mSlideHolder = ArticSlideHolder(view)
//            }
            mSlideHolder!!
        }else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.article_list_item, parent, false)
            ArticleItemHolder(view)
        }
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder : BaseArticItemHolder, position: Int) {
        if(holder is ArticleItemHolder) {
            var stories = mData[position] as Stories
            mContext?.let { Glide.with(it).load(stories.images[0]).into(holder.pic) }
            holder.title.text = stories.title
        }else if(holder is ArticSlideHolder){
            var stories = mData[position] as News
            holder.setAdapter()
            holder.mAdapter.addData(stories)
            holder.mAdapter.notifyDataSetChanged()
            var slideBox : LinearLayout = holder.itemView.findViewById(R.id.slide_box)
//            slideBox.removeAllViews()
            for (i in stories.news.indices){
                var point = View(holder.itemView.context)
                if(i == 0){
                    point.setBackgroundResource(R.drawable.point_selected)
                }else {
                    point.setBackgroundResource(R.drawable.point_normal)
                }
                var params : LinearLayout.LayoutParams = LinearLayout.LayoutParams(40, 40)
                params.leftMargin = 20
                point.layoutParams = params
                point.tag = i
                point.setOnClickListener { v ->
                    if (v != null) {
                        val index =  v.tag as Int
                        holder.slideView.currentItem = index
                    }
                }
                slideBox.addView(point)
            }
        }
    }

    open class BaseArticItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

    class ArticleItemHolder(itemView: View) : BaseArticItemHolder(itemView) {

        var pic : ImageView = itemView.findViewById(R.id.article_list_pic)
        var title : TextView = itemView.findViewById(R.id.article_list_title)


    }

    class ArticSlideHolder(itemView: View) : BaseArticItemHolder(itemView) {
        var mSlideDatas : ArrayList<ArticleBaseBean> = ArrayList()
        var slideView : ViewPager = itemView.findViewById(R.id.slideshow)
        var mAdapter : SlideShowPagerAdapter = SlideShowPagerAdapter(mSlideDatas);

        fun setAdapter(){
            slideView.adapter = mAdapter
            slideView.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
                override fun onPageScrollStateChanged(state: Int) {
                }

                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    var slideBox : LinearLayout = itemView.findViewById(R.id.slide_box)
                    var viewPrevSelect = slideBox.getChildAt(mSelectPointIndex)
                    viewPrevSelect.setBackgroundResource(R.drawable.point_normal)
                    mSelectPointIndex = position
                    var view : View = slideBox.getChildAt(mSelectPointIndex)
                    view.setBackgroundResource(R.drawable.point_selected)
                }

                override fun onPageSelected(position: Int) {
                }

            })
        }

    }

}