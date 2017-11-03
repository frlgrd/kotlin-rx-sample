package com.mobiapps.koltintest.core.common.ui

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

class SpaceDecoration(space: Int) : RecyclerView.ItemDecoration() {

    private var halfSpace: Int = space / 2
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        if (parent.paddingLeft != halfSpace) {
            parent.setPadding(halfSpace, halfSpace, halfSpace, halfSpace)
            parent.clipToPadding = false
        }
        outRect.bottom = halfSpace
        outRect.top = halfSpace
        outRect.left = halfSpace
        outRect.right = halfSpace
    }
}