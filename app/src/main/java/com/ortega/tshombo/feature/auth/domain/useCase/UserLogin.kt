package com.ortega.tshombo.feature.auth.domain.useCase

import com.ortega.tshombo.feature.auth.domain.entity.UserEntity
import com.ortega.tshombo.feature.auth.domain.repository.IAuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class UserLogin @Inject constructor(private val iAuthRepository: IAuthRepository) {

    suspend operator fun invoke(
        email: String,
        password: String,
        onSuccess: (UserEntity) -> Unit,
        onError: (String) -> Unit
    ) {
        try {
            val user = iAuthRepository.loginWithEmailAndPassword(email, password)
            onSuccess(user)
        } catch (e: HttpException) {
            onError(e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: IOException) {
            onError(e.localizedMessage ?: "Couldn't reach server. Check your internet connection.")
        }
    }

}