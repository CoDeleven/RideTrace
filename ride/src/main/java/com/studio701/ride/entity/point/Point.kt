package com.studio701.ride.entity.point

import com.mongodb.DBObject
import org.springframework.data.mongodb.core.mapping.Document

data class Point(val lat:Double, val lon:Double)