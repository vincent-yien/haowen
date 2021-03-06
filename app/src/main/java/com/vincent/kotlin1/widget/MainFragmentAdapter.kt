package com.vincent.kotlin1.widget

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.vincent.kotlin1.ui.fragment.ArticleFragment
import com.vincent.kotlin1.ui.fragment.PicFragment

class MainFragmentAdapter(fm: FragmentManager,var size : Int) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        var  fragment : Fragment = ArticleFragment()
        when(position) {
            0 ->
                fragment = ArticleFragment()

            1 ->
                fragment = PicFragment()
        }
        return fragment
    }

    override fun getCount(): Int {
        return  size
    }
}