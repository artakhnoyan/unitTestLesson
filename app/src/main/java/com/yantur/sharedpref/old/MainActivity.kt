package com.yantur.sharedpref.old

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yantur.sharedpref.R
import com.yantur.sharedpref.old.bussines.UserUseCase
import com.yantur.sharedpref.old.bussines.UserUseCaseImpl
import com.yantur.sharedpref.old.data.UserRepositoryImpl
import com.yantur.sharedpref.old.entity.User
import com.yantur.sharedpref.old.service.MyDBServiceImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var userUseCase: UserUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUserUseCase()
        create_user.setOnClickListener { saveUser() }
        get_user.setOnClickListener { showUser() }
    }

    private fun showUser() {
        val user = userUseCase.getUserById(user_id_get.text.toString())
        user_name_get.text = "Name: ${user.name}"
        user_surname_get.text = "Surname: ${user.surname}"
    }

    private fun saveUser() {
        val user = User(
            user_id.text.toString(),
            user_name.text.toString(),
            user_surname.text.toString()
        )
        userUseCase.writeUser(user)
    }

    private fun initUserUseCase() {
        userUseCase = UserUseCaseImpl(
            UserRepositoryImpl(
                MyDBServiceImpl(
                    applicationContext,
                    USERS_DB
                )
            )
        )
    }

    companion object {
        private const val USERS_DB = "users"
    }
}
