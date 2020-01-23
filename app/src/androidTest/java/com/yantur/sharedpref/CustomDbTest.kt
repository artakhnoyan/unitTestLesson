package com.yantur.sharedpref

import android.app.Instrumentation
import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import androidx.test.platform.app.InstrumentationRegistry
import com.yantur.sharedpref.new.CustomDB
import com.yantur.sharedpref.new.CustomDBImpl
import com.yantur.sharedpref.old.entity.User
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@SmallTest
internal class CustomDbTest {

    private val context: Context = InstrumentationRegistry.getInstrumentation().context
    lateinit var customDB : CustomDB

    @Before
    fun init() {
        customDB = CustomDBImpl(context, "users")
    }

    @Test
    fun `test_write_user`() {
        val id = "art"
        val user = User(id, "art", "art")
        customDB.createUser(user)
        val readUser = customDB.getUserById(id)

        Assert.assertEquals(user, readUser)
    }
}