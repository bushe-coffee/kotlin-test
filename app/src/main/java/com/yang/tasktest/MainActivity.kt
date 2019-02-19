package com.yang.tasktest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.yang.tasktest.ContantsUtils.ContantsData
import com.yang.tasktest.models.ImageModel
import com.yang.tasktest.presents.BasePresent
import com.yang.tasktest.presents.MainPresent
import com.yang.tasktest.views.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    var mAdapter : ImageListGridRecyclerAdapter? = null
    var curPresent : MainPresent? = null
    val spanCount = 2

    override fun setImageDatas(datas: List<ImageModel>) {
        mAdapter?.setMovieList(datas)
    }

    override fun netWorkSuccess(msg: String) {
        Toast.makeText(this@MainActivity,"请求成功...", Toast.LENGTH_SHORT).show()
    }

    override fun netWorkFail(msg: String) {
        Toast.makeText(this@MainActivity,"请求失败...", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var grid = GridLayoutManager(this,spanCount)
        main_list.layoutManager = grid
        main_list.addItemDecoration(RecyclerItemDecoration(10,spanCount))
        mAdapter = ImageListGridRecyclerAdapter(spanCount, this@MainActivity)
        main_list.adapter = mAdapter

        curPresent = MainPresent()
        curPresent?.initView(this)
        curPresent?.requestGallery(ContantsData.url)
    }

    override fun onStop() {
        super.onStop()
        curPresent?.removeView(this)
    }
}
