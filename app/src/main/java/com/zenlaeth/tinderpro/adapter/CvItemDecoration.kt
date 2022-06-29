package com.zenlaeth.tinderpro.adapter

import android.graphics.Rect
import androidx.recyclerview.widget.RecyclerView

class CvItemDecoration : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, itemPosition: Int, parent: RecyclerView) {
        outRect.bottom = 20
    }
}