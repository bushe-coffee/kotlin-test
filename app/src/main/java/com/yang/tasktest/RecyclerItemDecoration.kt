package com.yang.tasktest

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class RecyclerItemDecoration(gridSpacingPx:Int, gridSize:Int) : RecyclerView.ItemDecoration() {

    private var itemSpace : Int = gridSpacingPx
    private var itemNum : Int= gridSize

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.bottom = itemSpace
        if (parent.getChildLayoutPosition(view)%itemNum == 0){  //parent.getChildLayoutPosition(view) 获取view的下标
            outRect.left = 0;
        } else {
            outRect.left = itemSpace;
        }
    }

}