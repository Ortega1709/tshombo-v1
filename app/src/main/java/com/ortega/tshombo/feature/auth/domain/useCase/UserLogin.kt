package com.ortega.tshombo.feature.auth.domain.useCase

import android.util.Log
import com.ortega.tshombo.core.utils.PreferencesManager
import com.ortega.tshombo.feature.auth.domain.entity.UserEntity
import com.ortega.tshombo.feature.auth.domain.repository.IAuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class UserLogin @Inject constructor(
    private val iAuthRepository: IAuthRepository,
    private val preferencesManager: PreferencesManager
) {

    suspend operator fun invoke(
        email: String,
        password: String,
        onSuccess: (UserEntity) -> Unit,
        onError: (String) -> Unit
    ) {
        try {
            val response = iAuthRepository.loginWithEmailAndPassword(email, password)
            if (response.code() == 200) {
                if (response.body() != null) {
                    // Log.d("USER LOGIN", response.body()!!.data.toString())

                    val user = response.body()!!.data
                    preferencesManager.saveData("userId", user.userId.toString())
                    preferencesManager.saveData("email", user.email)
                    preferencesManager.saveData("role", user.role.name)

                    onSuccess(response.body()!!.data)
                }
            } else {
                onError("Authentication error")
            }

        } catch (e: HttpException) {
            onError(e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: IOException) {
            onError(e.localizedMessage ?: "Couldn't reach server. Check your internet connection.")
        }
    }

}