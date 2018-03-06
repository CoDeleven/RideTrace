package com.studio701.user

import com.studio701.entity.User
import com.studio701.entity.common.ResponseObject
import com.studio701.entity.friend.FriendNote
import com.studio701.user.dao.UserDao
import com.studio701.utils.JsonUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.RestTemplate
import java.net.URI

@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    private lateinit var template: RestTemplate

    @Autowired
    lateinit var dao: UserDao

    @RequestMapping("/{userId}", method = [RequestMethod.GET])
    fun getUserDetail(@PathVariable("userId") userId: String): ResponseObject<User?> {
        return ResponseObject(dao.queryUser(userId = userId))
    }

    @RequestMapping("/", method = [RequestMethod.POST])
    fun createUser(@RequestBody user: User): ResponseObject<String> {
        dao.createUser(user)
        return ResponseObject()
    }

    @RequestMapping("/more/{userIdList}", method = [RequestMethod.GET])
    fun getListUserDetails(@PathVariable("userIdList") userIdList: String): ResponseObject<List<User>> {
        val list = userIdList.split("&")

        return ResponseObject(dao.queryUser(list))
    }


    @RequestMapping("/{userId}/favorite/note", method = [RequestMethod.GET])
    fun getFavoriteNote(@PathVariable("userId") userId: String): ResponseObject<List<FriendNote>> {
        return ResponseObject(dao.listFavoriteNote(userId))
    }


    @RequestMapping("/{userId}/favorite/{noteId}", method = [RequestMethod.PUT])
    fun insertFavoriteNote(@PathVariable("userId") userId: String, @PathVariable("noteId") noteId: String): ResponseObject<String> {
        dao.insertFavoriteNote(userId, noteId)
        return ResponseObject()
    }

    private fun dispatchRPCRequest(url: String, queryKey: String, ids: List<String>): ResponseObject<*> {
        var queryParam = String()
        for (s in ids) {
            queryParam += (s + "&")
        }

        val responseObject = template.getForObject(
                URI.create(url + "?" + queryKey + "=" + queryParam.subSequence(0, queryParam.length - 1))
                , ResponseObject::class.java)
        val responseEntity = JsonUtils.convertAny2Another(responseObject, ResponseObject::class.java)
        return responseEntity
    }
}