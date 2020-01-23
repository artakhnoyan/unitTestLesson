package com.yantur.sharedpref

import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import androidx.test.platform.app.InstrumentationRegistry
import com.yantur.sharedpref.old.entity.User
import com.yantur.sharedpref.old.service.MyDBService
import com.yantur.sharedpref.old.service.MyDBServiceImpl
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
internal class MyDBServiceImplTest {
    private val context: Context = InstrumentationRegistry.getInstrumentation().context
    private val myDBService: MyDBService =
        MyDBServiceImpl(context, "users")

    @Test
    fun `test_write_and_get_user`() {
        val user = User(
            id = "12",
            name = "Art",
            surname = "Akhnoyan"
        )
        myDBService.putUser(user)

        val retrievedUser = myDBService.getUserById("12")

        Assert.assertEquals(user, retrievedUser)
    }
//
//    @Test
//    fun `failing_test`() {
//        val user = User(id = "12", name = "Art", surname = "Akhnoyan")
//        myDBService.putUser(user)
//
//        Assert.assertEquals(user, User("a", "a", "a"))
//    }
}