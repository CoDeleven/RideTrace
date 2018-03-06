package com.studio701.user.dao

import com.studio701.entity.User
import com.studio701.entity.friend.FriendNote
import com.studio701.entity.routebook.RouteBook
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Component


@Component
open class UserDao {
    companion object {
        private const val COLLECTION_NAME = "user"
    }

    @Autowired
    private lateinit var template: MongoTemplate

    fun createUser(user: User) {
        if (!template.collectionExists(COLLECTION_NAME)) {
            template.createCollection(COLLECTION_NAME)
        }
        template.insert(user, COLLECTION_NAME)
    }

    fun queryUser(userId: String): User? {
        val users = template.find(Query.query(Criteria.where("_id").`is`(userId)),
                User::class.java, COLLECTION_NAME)
        if (users.size > 0) {
            return users[0]
        }
        return null
    }

    fun queryUser(userIdList: List<String>): List<User> {
        val userList = template.find(Query.query(Criteria.where("_id").`in`(userIdList)),
                User::class.java, COLLECTION_NAME)
        return userList
    }


    fun listFavoriteNote(userId: String): List<FriendNote> {
        val ids = selectSinglePartData("_id", userId, "favoriteNote", COLLECTION_NAME)
        return template.find(Query.query(Criteria.where("_id").`in`(ids)), FriendNote::class.java, "friend_note")
    }


    private fun selectSinglePartData(key: String, value: String, includeField: String, collectionName: String = COLLECTION_NAME): List<String> {
        val query = Query()
        query.fields().include(includeField)
        query.addCriteria(Criteria.where(key).`is`(value))
        val foo = template.find(query, HashMap::class.java, collectionName)

        if (foo[0][includeField] is List<*>) {
            return foo[0][includeField] as List<String>
        }
        return listOf()
    }

    fun insertFavoriteNote(userId: String, noteId: String) {
        template.updateFirst(Query.query(Criteria.where("_id").`is`(userId)),
                Update().addToSet("favoriteNote", noteId), COLLECTION_NAME)
    }
}