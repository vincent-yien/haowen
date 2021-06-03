package com.vincent.kotlin1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import butterknife.BindView
import butterknife.ButterKnife
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.vincent.kotlin1.R
import com.vincent.kotlin1.bean.Data
import com.vincent.kotlin1.synccallback.HttpCallBack
import com.vincent.kotlin1.util.HttpConstans
import com.vincent.kotlin1.util.HttpUtil
import com.vincent.kotlin1.widget.MainFragmentAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_box_item.*
import org.json.JSONObject
import java.util.*
import java.util.zip.Inflater

class MainActivity : BaseActivity(), View.OnClickListener {

    private val box_pic_id = arrayOf(R.mipmap.ic_news_24dp,R.mipmap.ic_photo_24dp,R.mipmap.ic_video_24dp,R.mipmap.ic_about_me)
    private val box_name_id = arrayOf(R.string.text,R.string.picture,R.string.video,R.string.about)
    private lateinit var fragmentAdapter : MainFragmentAdapter
    private lateinit var mainViewPager : ViewPager

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
            if(textView != null){
                when(textView.text){
                    resources.getText(R.string.text) ->
                        mainViewPager.currentItem = 0

                }
            }
        }
    }

}