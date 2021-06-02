package com.vincent.kotlin1.ui.fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.vincent.kotlin1.R

class ArticleFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.article_fragment,container,false)
        return view;
    }

    override fun getView(): View? {
        return super.getView()
    }
}