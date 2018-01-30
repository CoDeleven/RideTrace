package com.studio701.ride.utils

class MapUtils {
    companion object {
        fun isKeyExists(set:Set<String>, vararg string: String):Boolean{
            return string.all {
                set.contains(it)
            }
        }
    }
}