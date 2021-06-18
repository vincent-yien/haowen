package com.vincent.kotlin1.widget

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView


class SpacesItemDecoration(space : Int) : RecyclerView.ItemDecoration() {

    private var space : Int = 0

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.left = space;
        outRect.right = space;
        outRect.bottom = space;
        if (parent.getChildPosition(view) == 0)
            outRect.top = space
    }

}