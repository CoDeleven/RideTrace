package com.studio701.activity.entity

data class ResponseObject<T>(
        val data:T?,
        val state:Int,
        val message:String
) {
    constructor():this(null, 200, "ok")
    constructor(data:T):this(data, 200, "ok")
    constructor(state:Int, message:String):this(null, state, message)

}