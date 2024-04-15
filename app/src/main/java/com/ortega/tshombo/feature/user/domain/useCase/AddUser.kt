package com.ortega.tshombo.feature.user.domain.useCase

import android.util.Log
import com.ortega.tshombo.feature.user.domain.entity.UserEntity
import com.ortega.tshombo.feature.user.domain.repository.IUserRepository
import com.ortega.tshombo.feature.user.domain.request.UserRequest
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class AddUser @Inject constructor(private val iUserRepository: IUserRepository) {

    suspend operator fun invoke(
        userRequest: UserRequest,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        try {
            val response = iUserRepository.addUsers(userRequest = userRequest)
            if (response.code() == 201) {
                onSuccess()
            } else {
                onError("Add error")
            }

        } catch (e: HttpException) {
            onError(e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: IOException) {
            onError(e.localizedMessage ?: "Couldn't reach server. Check your internet connection.")
        }
    }

}