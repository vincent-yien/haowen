package com.vincent.kotlin1.widget

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vincent.kotlin1.R
import com.vincent.kotlin1.util.ImageLoadUtil

class PictureAdapter : RecyclerView.Adapter<PictureAdapter.PictureHolder>(){

    private var mData : ArrayList<String> = ArrayList<String>()

    public fun setData(array : ArrayList<String>){
        if(array != null){
            mData = array
        }
    }

    public fun addData(array: ArrayList<String>){
        if(array != null){
            mData.addAll(array)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureHolder {
        var view =  LayoutInflater.from(parent.context).inflate(R.layout.picture_item,parent,false)
        return PictureHolder(view)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: PictureHolder, position: Int) {
        ImageLoadUtil.displayImageCenter(holder.picture,mData[position],holder.itemView.context,R.drawable.ic_launcher_background)
    }


    class PictureHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        public var picture : ImageView = itemView.findViewById(R.id.picture_id)
        public var title : TextView = itemView.findViewById(R.id.picture_title_id)
    }

    override fun onViewRecycled(holder: PictureHolder) {
        super.onViewRecycled(holder)
        if(holder.itemView!=null){
            holder.itemView.context?.let { Glide.with(it).clear(holder.itemView) }
        }
    }
}