package com.yantur.sharedpref.old.bussines

import com.yantur.sharedpref.old.entity.User
import com.yantur.sharedpref.old.entity.UserData

interface UserUseCase2 {
    fun getUser(userData: UserData): User
}

class UserUseCase2Impl(
    private val userRepo: UserRepo
) : UserUseCase2 {
    override fun getUser(userData: UserData): User {
        val user = userRepo.findUser(userData.id) ?: throw IllegalArgumentException("user doesn't exist")
        if (userData.type == 1) {
            user.surname = user.surname + user.name
        }
        return user
    }

}

interface UserRepo {
    fun findUser(id: String): User?
}


