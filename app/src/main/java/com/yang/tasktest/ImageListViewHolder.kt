package com.yang.tasktest

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yang.tasktest.models.ImageModel
import kotlinx.android.synthetic.main.item_image.view.*

class ImageListViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {

    fun bindView(movieModel: ImageModel) {
        itemView.item_msg.text = movieModel.title

        Glide.with(itemView.context).load(movieModel.link!!).into(itemView.item_img)
    }
}