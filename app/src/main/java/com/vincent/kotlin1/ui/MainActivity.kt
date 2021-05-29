package com.vincent.kotlin1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import butterknife.BindView
import butterknife.ButterKnife
import com.vincent.kotlin1.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_box_item.*
import java.util.zip.Inflater

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadUI()
    }

    fun loadUI(){
        var infalter = layoutInflater
        for(index in 1..4){
            var view = infalter.inflate(R.layout.bottom_box_item,bottom_box)
            var box_image : ImageView = view.findViewById(R.id.box_image)
            var box_title : TextView = view.findViewById(R.id.box_title)
            box_image.background = this.resources.getDrawable(R.mipmap.ic_news_24dp)
            box_title.setText("文章")
            var parent : ViewGroup = view.parent as ViewGroup
            parent.removeView(view)
            bottom_box.addView(view)
        }
    }

}