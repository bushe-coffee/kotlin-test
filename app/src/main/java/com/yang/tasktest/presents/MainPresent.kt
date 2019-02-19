package com.yang.tasktest.presents

import android.util.Log
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.TextHttpResponseHandler
import com.yang.tasktest.models.BaseModel
import com.yang.tasktest.models.ImageModel
import com.yang.tasktest.views.BaseView
import com.yang.tasktest.views.MainView
import cz.msebera.android.httpclient.Header
import org.json.JSONArray

class MainPresent : BasePresent {

    var currentView : MainView? = null

    override fun initView(base_view: BaseView) {
        currentView = base_view as MainView
    }

    override fun removeView(base_view: BaseView) {
        currentView = null
    }

    fun requestGallery(url : String) {
        val client = AsyncHttpClient()
        client.addHeader("Authorization","Client-ID c527519d4782c63")
        client.addHeader("Accept", "application/json")
        client.addHeader("Content-Type", "application/json")

        client.get(url,null, object : TextHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Array<out Header>?, responseString: String?) {

                var jsonObj = BaseModel(responseString!!)
                if (jsonObj.success) {
                    var array = jsonObj.data
                    var imgList = mutableListOf<ImageModel>()
                    for (i in 0 until array!!.length()) {
                        imgList.add(ImageModel(array.optJSONObject(i)))
                    }

                    currentView?.setImageDatas(imgList)
                }
                currentView?.netWorkSuccess("success")
            }

            override fun onFailure(statusCode: Int, headers: Array<out Header>?, responseString: String?, throwable: Throwable?) {
                Log.d("yang", responseString)
                currentView?.netWorkFail("请求失败")
            }

        })
    }
}