package com.yang.tasktest.models

import org.json.JSONArray
import org.json.JSONObject


open class BaseModel() {
    var data : JSONArray? = null
    var success =false
    var status =0

    init {

    }

    constructor(json: String) : this() {
        var obj = JSONObject(json)
        success = obj.optBoolean("success")
        data = obj.optJSONArray("data")
        status = obj.optInt("status")
    }


}