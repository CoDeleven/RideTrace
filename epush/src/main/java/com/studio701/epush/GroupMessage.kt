package com.studio701.epush

import java.util.*

data class GroupMessage(
        val fromUserId:String,
        val toGroupId:String,
        val sendTime:Date,
        val extraInfo:Map<String, String>?
)