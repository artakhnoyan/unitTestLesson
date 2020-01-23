package com.yantur.sharedpref.old.data

import com.yantur.sharedpref.old.service.MyDBService
import com.yantur.sharedpref.old.entity.User
import com.yantur.sharedpref.old.bussines.UserRepository


class UserRepositoryImpl(
    private val sharePrefService: MyDBService
): UserRepository {
    override fun saveUser(user: User) = sharePrefService.putUser(user)
    override fun getUserById(id: String): User = sharePrefService.getUserById(id)
}
