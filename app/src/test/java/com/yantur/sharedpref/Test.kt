package com.yantur.sharedpref

import com.yantur.sharedpref.old.bussines.UserRepo
import com.yantur.sharedpref.old.bussines.UserUseCase2
import com.yantur.sharedpref.old.bussines.UserUseCase2Impl
import com.yantur.sharedpref.old.entity.User
import com.yantur.sharedpref.old.entity.UserData
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class Test {

    private val userRepo: UserRepo = mockk()

    private val userUseCase2: UserUseCase2 = UserUseCase2Impl(userRepo)


    @Test
    fun `test get user`()  = {
        val user = User("art", "art", "art")
        every { userRepo.findUser("art") } returns user
        Assertions.assertEquals(user, userUseCase2.getUser(UserData("art", 1)))
    }

    @Test
    fun `test user doesn't exist`() {
        every { userRepo.findUser("1") } returns null
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            userUseCase2.getUser(UserData(id = "1", type = 1))
        }
    }

    @Test
    fun `test type 1 user`() {
        every { userRepo.findUser("art") } returns User("art", "art", "art")
        val returnedUser = userUseCase2.getUser(UserData(id = "art", type = 1))
        Assertions.assertEquals(User("art", "art", "artart"), returnedUser)

    }
}

// Get user, by id, also check user type and do some work