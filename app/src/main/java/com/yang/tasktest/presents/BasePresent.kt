package com.yang.tasktest.presents

import com.yang.tasktest.views.BaseView

interface BasePresent {

    fun initView(base_view:BaseView)

    fun removeView(base_view:BaseView)

}