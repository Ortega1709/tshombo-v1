package com.ortega.tshombo.feature.user.domain.useCase

import com.ortega.tshombo.feature.user.domain.repository.IUserRepository
import com.ortega.tshombo.feature.user.domain.request.UserRequest
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class DeleteUser @Inject constructor(private val iUserRepository: IUserRepository) {

    suspend operator fun invoke(
        userId: Int,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        try {
            val response = iUserRepository.deleteUserById(userId = userId)
            if (response.code() == 200) {
                onSuccess()
            } else {
                onError("Delete error")
            }

        } catch (e: HttpException) {
            onError(e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: IOException) {
            onError(e.localizedMessage ?: "Couldn't reach server. Check your internet connection.")
        }
    }

}