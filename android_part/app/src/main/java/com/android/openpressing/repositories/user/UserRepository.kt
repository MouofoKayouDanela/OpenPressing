package com.android.openpressing.repositories.user

import com.android.openpressing.data.OpenPressingStrapiApi
import com.android.openpressing.data.models.user.User
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userApi: OpenPressingStrapiApi.UserApi
) {

    suspend fun getAll() : List<User> = userApi.getAll()

    suspend fun getById(id: Int) : User = userApi.getById(id)

}