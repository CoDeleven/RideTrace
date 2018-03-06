package com.studio701.friend.controller

import com.studio701.entity.common.ResponseObject
import com.studio701.entity.friend.FriendNote
import com.studio701.entity.routebook.Comment
import com.studio701.friend.dao.FriendDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/friend")
class FriendController {
    @Autowired
    private lateinit var friendDao: FriendDao

    @RequestMapping("/", method = [RequestMethod.POST])
    fun createNote(@RequestBody note: FriendNote): ResponseObject<String> {
        friendDao.createNote(friendNote = note)
        return ResponseObject()
    }

    @RequestMapping("/{userId}/praise/{noteId}", method = [RequestMethod.PUT])
    fun createPraise(@PathVariable("userId") userId: String, @PathVariable("noteId") noteId: String): ResponseObject<String> {
        friendDao.createPraise(userId, noteId)
        return ResponseObject()
    }

    @RequestMapping("/comment", method = [RequestMethod.PUT])
    fun createComment(@RequestBody comment: Comment): ResponseObject<String> {
        friendDao.createComment(comment)
        return ResponseObject()
    }

    @RequestMapping("/", method = [RequestMethod.GET])
    fun listNotes(@RequestParam("skip") skip: Int, @RequestParam("num") num: Int): ResponseObject<List<FriendNote>> {
        return ResponseObject(friendDao.listNote(skip, num))
    }

    @RequestMapping("/comment-list/{NOTE_ID}", method = [RequestMethod.GET])
    fun listComments(@PathVariable("NOTE_ID") noteId: String, @RequestParam("skip") skip: Int, @RequestParam("num") num: Int): ResponseObject<List<Comment>> {
        return ResponseObject(friendDao.listComments(noteId, skip, num))
    }

}