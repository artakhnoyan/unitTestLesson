package com.yantur.sharedpref.old.service

import android.content.Context
import com.yantur.sharedpref.old.entity.User

interface MyDBService {
    fun putUser(user: User)
    fun getUserById(id: String): User
}

class MyDBServiceImpl(
    context: Context,
    dbName: String
) : MyDBService {
    private val prefs = context.getSharedPreferences(dbName, Context.MODE_PRIVATE)

    override fun putUser(user: User) {
        with(prefs.edit()) {
            val id = user.id
            putString("${ID_KEY}_$id", user.id)
            putString("${NAME_KEY}_$id", user.name)
            putString("${SURNAME_KEY}_$id", user.surname)
            apply()
        }
    }

    override fun getUserById(id: String): User = with(prefs) {
        User(
            id = getString(
                "${ID_KEY}_$id",
                ""
            ) ?: "",
            name = getString(
                "${NAME_KEY}_$id",
                ""
            ) ?: "",
            surname = getString(
                "${SURNAME_KEY}_$id",
                ""
            ) ?: ""
        )
    }


    companion object {
        private const val ID_KEY = "id"
        private const val NAME_KEY = "name"
        private const val SURNAME_KEY = "surname"
    }
}
