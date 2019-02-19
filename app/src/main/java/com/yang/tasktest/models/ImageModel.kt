package com.yang.tasktest.models

import org.json.JSONObject

class ImageModel(optJSONObject: JSONObject) : BaseModel() {

    var id : String?=optJSONObject.optString("id")
    var title : String?=optJSONObject.optString("title")
    var link : String?=optJSONObject.optString("link")
    var type : String?=optJSONObject.optString("type")
    var width : Int?=optJSONObject.optInt("width")
    var height : Int?=optJSONObject.optInt("height")
    var size : Int?=optJSONObject.optInt("size")


//
//        "description": null,
//        "datetime": 1549014003,
//        "type": "image/jpeg",
//        "animated": false,
//        "width": 684,
//        "height": 756,
//        "size": 303752,
//        "views": 39707,
//        "bandwidth": 12061080664,
//        "vote": null,
//        "favorite": false,
//        "nsfw": false,
//        "section": "funny",
//        "account_url": null,
//        "account_id": null,
//        "is_ad": false,
//        "in_most_viral": false,
//        "has_sound": false,
//        "tags": [],
//        "ad_type": 0,
//        "ad_url": "",
//        "in_gallery": false,
//        "link": "https://i.imgur.com/d3CLzug.jpg",
//        "ad_config": {
//        "safeFlags": [
//        "onsfw_mod_safe"
//        ],
//        "highRiskFlags": [
//        "not_in_gallery",
//        "subreddit"
//        ],
//        "unsafeFlags": [],
//        "showsAds": true
//    },
//        "comment_count": null,
//        "favorite_count": null,
//        "ups": null,
//        "downs": null,
//        "points": null,
//        "score": 35094,
//        "is_album": false
//    },
}