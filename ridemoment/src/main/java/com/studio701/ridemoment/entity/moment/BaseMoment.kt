package com.studio701.ridemoment.entity.moment

import com.studio701.ridemoment.entity.User
import java.util.*

data class BaseMoment(
        val user: User, val publishDate: Date,
        val goodNum:Int, val commentNum:Int,
        val textContent:String, val gentleman:List<String>);