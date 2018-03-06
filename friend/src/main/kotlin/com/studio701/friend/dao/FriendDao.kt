package com.studio701.friend.dao

import com.fasterxml.jackson.databind.ObjectMapper
import com.studio701.entity.friend.FriendNote
import com.studio701.entity.moment.FavoriteItem
import com.studio701.entity.routebook.Comment
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Component

@Component
open class FriendDao {
    @Autowired
    private lateinit var template:MongoTemplate

    companion object {
        private const val NOTE_COLLECTION_NAME = "friend_note"
        private const val COMMENT_COLLECTION_NAME = "friend_comment"
    }

    fun createNote(friendNote: FriendNote){
        if(!template.collectionExists(NOTE_COLLECTION_NAME)){
            template.createCollection(NOTE_COLLECTION_NAME)
        }
        template.insert(friendNote, NOTE_COLLECTION_NAME)
    }

    fun createComment(comment: Comment){
        if(!template.collectionExists(COMMENT_COLLECTION_NAME)){
            template.createCollection(COMMENT_COLLECTION_NAME)
        }
        template.insert(comment, COMMENT_COLLECTION_NAME)
        template.updateFirst(Query.query(Criteria.where("_id").`is`(comment.belongId)),
                Update().inc("comment", 1), NOTE_COLLECTION_NAME)
    }

    fun createPraise(userId:String, noteId:String){

        template.upsert(
                Query.query(Criteria.where("_id").`is`(noteId)),
                Update().addToSet("praiseList", userId).inc("praise", 1), NOTE_COLLECTION_NAME
        )
    }

    fun listNote(skip:Int, num:Int):List<FriendNote>{
        return template.find(Query().skip(skip).limit(num), FriendNote::class.java, NOTE_COLLECTION_NAME)
    }

    fun listComments(nodeId:String, skip:Int, num:Int):List<Comment>{
        return template.find(Query.query(Criteria.where("belongId").`is`(nodeId)).skip(skip).limit(num),
                Comment::class.java,
                COMMENT_COLLECTION_NAME)
    }
}