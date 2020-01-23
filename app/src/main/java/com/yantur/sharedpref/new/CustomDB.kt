package com.yantur.sharedpref.new

import android.content.Context
import com.yantur.sharedpref.old.entity.User

interface CustomDB {
    fun createUser(user: User)
    fun getUserById(id: String): User
}

class CustomDBImpl(
    context: Context,
    dbName: String
) : CustomDB {
    private val sharedPreferences = context.getSharedPreferences(dbName, Context.MODE_PRIVATE)

    override fun createUser(user: User) {
        with(sharedPreferences.edit()) {
            putString("id_${user.id}", user.id)
            putString("name_${user.id}", user.name)
            putString("surname_${user.id}", user.surname)
            apply()
        }
    }

    override fun getUserById(id: String): User =
        with(sharedPreferences) {
            User(
                id = getString("id_${id}", "") ?: "",
                name = getString("name_${id}", "") ?: "",
                surname = getString("surname_${id}", "") ?: ""
            )
        }
}