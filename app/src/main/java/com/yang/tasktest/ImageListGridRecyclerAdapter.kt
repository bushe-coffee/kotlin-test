package com.yang.tasktest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yang.tasktest.models.ImageModel

class ImageListGridRecyclerAdapter(gridSize:Int, context:Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listImgs = listOf<ImageModel>()
    private var grid_size : Int = gridSize
    private var itemHeight:Int=0
    init {
        itemHeight = context.resources.displayMetrics.widthPixels / grid_size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        var itemView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        itemView.layoutParams.height = itemHeight
        return ImageListViewHolder(itemView)

    }

    override fun getItemCount(): Int = listImgs.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var imgHoleder = holder as ImageListViewHolder
        imgHoleder.bindView(listImgs[position])
    }

    fun setMovieList(listOfMovies: List<ImageModel>) {
        this.listImgs = listOfMovies
        notifyDataSetChanged()
    }
}