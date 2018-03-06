package com.studio701.ridemoment.controller

import com.studio701.entity.User
import com.studio701.entity.match.Match
import com.studio701.ridemoment.dao.MatchDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import java.util.*

@Controller
class MatchController {
    @Autowired
    private lateinit var matchDao: MatchDao
    companion object {
        private val matchListCache = mutableMapOf<String, Match>()
    }
    @RequestMapping(value = ["/match-list"], method = [RequestMethod.GET])
    fun getMatchList(model: Model): String {
        val matchList = matchDao.getListMatch()
        val dateMap = hashMapOf<String, Date>()
        if(matchListCache != null){
            matchList.forEach {
                matchListCache[it.id] = it
                dateMap.put(it.id, Date(it.startTime))
            }
        }
        model.addAttribute("itemList", matchList)
        model.addAttribute("dateMap", dateMap)
        return "index";
    }

    @RequestMapping(value = ["/sub/{MATCH_ID}"], method = [RequestMethod.GET])
    fun getMatchDetail(@PathVariable("MATCH_ID") matchId:String, model:Model): String {

        val matchItem = matchListCache[matchId]

        model.addAttribute("matchItem", matchItem)
        return "sub"
    }
}