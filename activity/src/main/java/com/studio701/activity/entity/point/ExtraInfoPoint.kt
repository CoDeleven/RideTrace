package com.studio701.ride.entity.point

data class ExtraInfoPoint(val extraInfo:Map<InfoType, List<String>>, val point:Point){
    enum class InfoType(val descriptor:String){
        VIDEO("video"), PHOTO("photo"), SPEED("speed")
    }
}