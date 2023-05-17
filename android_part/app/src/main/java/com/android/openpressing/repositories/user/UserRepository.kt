package com.android.openpressing.repositories.user


import com.android.openpressing.data.OpenPressingStrapiApi
import com.android.openpressing.data.models.user.User
import com.android.openpressing.data.models.user.UserData
import javax.inject.Inject

class UserRepository@Inject constructor(
    private val userApi : OpenPressingStrapiApi.UserApi
) {

    suspend fun getAll() : List<User> = userApi.getAll()
    suspend fun getById(id: Int) : User = userApi.getById(id)

    suspend fun save(user: User) = userApi.save(user)

    suspend fun update(id: Int, user: User) : User = userApi.update(id, user)

    suspend fun delete(id: Int) {

        val userService = getById(id)
        userService.confirmed=false

        update(id, userService)
    }

}