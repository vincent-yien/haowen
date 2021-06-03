package com.vincent.kotlin1.widget

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vincent.kotlin1.R
import com.vincent.kotlin1.bean.Data

class ArticleListAdapter : RecyclerView.Adapter<ArticleListAdapter.ArticleItemHolder>() {

    private lateinit var mData : ArrayList<Data>

    fun setData( data : ArrayList<Data>){
        mData = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleListAdapter.ArticleItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.article_list_item,parent,false)
        Log.d("RANWS","createView")
        return ArticleItemHolder(view)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: ArticleListAdapter.ArticleItemHolder, position: Int) {
//        holder.itemView.findViewById<ImageView>(R.id.article_list_pic).background =
        holder.title.text = mData[position].excerpt
        Log.d("RANWS","data:"+(mData[position].excerpt))
    }

    class ArticleItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var pic : ImageView = itemView.findViewById(R.id.article_list_pic)
        var title : TextView = itemView.findViewById(R.id.article_list_title)


    }

}