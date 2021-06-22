package com.vincent.kotlin1.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.vincent.kotlin1.R
import com.vincent.kotlin1.widget.MainFragmentAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : BaseActivity(), View.OnClickListener {

    private val box_pic_id = arrayOf(R.mipmap.ic_news_24dp,R.mipmap.ic_photo_24dp,R.mipmap.ic_video_24dp,R.mipmap.ic_about_me)
    private val last_box_pic_id = arrayOf(R.mipmap.ic_news_24dp,R.mipmap.ic_photo_24dp,R.mipmap.ic_video_24dp,R.mipmap.ic_about_me)
    private val box_name_id = arrayOf(R.string.text,R.string.picture,R.string.video,R.string.about)
    private lateinit var fragmentAdapter : MainFragmentAdapter
    private lateinit var mainViewPager : ViewPager
    private var lastPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadUI()

    }

    fun loadUI(){
        val infalter = LayoutInflater.from(this)
        for(index in 0..3){
            var view = infalter.inflate(R.layout.bottom_box_item,bottom_box,false);
            var box_image : ImageView = view.findViewById(R.id.box_image)
            var box_title : TextView = view.findViewById(R.id.box_title)
            box_image.background = this.resources.getDrawable(box_pic_id[index])
            box_title.setText(box_name_id[index])
            bottom_box.addView(view)
            view.setOnClickListener(this)
        }
            mainViewPager = content
            fragmentAdapter = MainFragmentAdapter(supportFragmentManager,4)
            mainViewPager.adapter = fragmentAdapter
            mainViewPager.currentItem = 0


    }

    override fun onClick(v: View?) {
        if (v != null){
            var textView =  v.findViewById<TextView>(R.id.box_title)
            var imageView = v.findViewById<ImageView>(R.id.box_image)
            if(textView != null){
                when(textView.text){
                    resources.getText(R.string.text) ->
                        mainViewPager.currentItem = 0

                    resources.getText(R.string.picture) ->
                        mainViewPager.currentItem = 1
                }
            }

        }
    }

    fun changeBoxStatus(position : Int){

    }

}