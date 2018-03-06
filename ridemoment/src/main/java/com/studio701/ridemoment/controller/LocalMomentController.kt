package com.studio701.ridemoment.controller

import com.studio701.entity.common.ResponseObject
import com.studio701.entity.moment.Moment
import com.studio701.ridemoment.dao.MomentDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.RestTemplate
import java.util.*

@RestController
@RequestMapping(path = ["/moments"])
class LocalMomentController {

    @Autowired
    lateinit var momentDao: MomentDao

    @Autowired
    lateinit var restTemplate:RestTemplate;

    @RequestMapping("/", method = [RequestMethod.GET])
    fun getLatestMoment( @RequestParam("skip") skip:Int, @RequestParam("num") num:Int): ResponseObject<List<Moment>> {

        return ResponseObject(momentDao.queryMoment("", skip, num))
    }

    @RequestMapping("/", method = [RequestMethod.POST], consumes = ["application/json"])
    fun createMoment(@RequestBody moment:Moment): ResponseObject<String> {
        momentDao.createMoment(moment)
        return ResponseObject()
    }

    @RequestMapping("/", method = [RequestMethod.PUT], consumes = ["application/json"])
    fun updateMoment(@RequestBody moment:Moment): ResponseObject<String> {
        momentDao.updateMoment(moment)
        return ResponseObject()
    }
}