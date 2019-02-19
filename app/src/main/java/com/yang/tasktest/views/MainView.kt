package com.yang.tasktest.views

import com.yang.tasktest.models.ImageModel

interface MainView : BaseView {

   fun setImageDatas(datas : List<ImageModel>)

}