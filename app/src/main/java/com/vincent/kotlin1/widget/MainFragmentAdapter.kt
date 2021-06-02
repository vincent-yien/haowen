package com.vincent.kotlin1.widget

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.vincent.kotlin1.ui.fragment.ArticleFragment

class MainFragmentAdapter(fm: FragmentManager,var size : Int) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        lateinit var  fragment : Fragment
        when(position){
            0 -> fragment = ArticleFragment()
        }
        fragment = ArticleFragment()
        return fragment
    }

    override fun getCount(): Int {
        return  size
    }
}