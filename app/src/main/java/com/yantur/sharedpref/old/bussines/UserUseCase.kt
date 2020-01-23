package com.yantur.sharedpref.old.bussines

import com.yantur.sharedpref.old.entity.User

interface UserUseCase  {
    fun writeUser(user: User)
    fun getUserById(id: String): User
}

class UserUseCaseImpl(
    private val userRepository: UserRepository
): UserUseCase {
    override fun writeUser(user: User) = userRepository.saveUser(user)
    override fun getUserById(id: String): User = userRepository.getUserById(id)
}

interface UserRepository {
    fun saveUser(user: User)
    fun getUserById(id: String): User
}