package com.android.openpressing.repositories.user

import android.net.Uri
import androidx.compose.ui.platform.LocalContext
import androidx.core.net.toFile
import com.android.openpressing.data.OpenPressingStrapiApi
import com.android.openpressing.data.models.user.User
import dagger.hilt.android.internal.Contexts.getApplication
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userApi: OpenPressingStrapiApi.UserApi
) {

    suspend fun getAll() : List<User> = userApi.getAll()

    suspend fun getById(id: Int) : User = userApi.getById(id)

    suspend fun save(user : User, image: Uri) {

        val requestBody = image.toFile().asRequestBody("image/*".toMediaTypeOrNull())
        val imagePart = MultipartBody.Part.createFormData("image", user.profile_picture.name, requestBody )
        userApi.save(user, imagePart)
    }

    suspend fun update( id: Int, user: User) : User = userApi.update(id, user)

}