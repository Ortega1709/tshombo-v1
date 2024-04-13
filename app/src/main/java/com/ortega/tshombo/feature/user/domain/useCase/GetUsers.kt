package com.ortega.tshombo.feature.user.domain.useCase

import android.util.Log
import com.ortega.tshombo.feature.home.domain.entity.PhoneEntity
import com.ortega.tshombo.feature.user.domain.entity.UserEntity
import com.ortega.tshombo.feature.user.domain.repository.IUserRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetUsers @Inject constructor(private val iUserRepository: IUserRepository) {

    suspend operator fun invoke(
        onSuccess: (List<UserEntity>) -> Unit,
        onError: (String) -> Unit
    ) {
        try {
            val response = iUserRepository.getAllUsers()
            if (response.code() == 200) {
                if (response.body() != null) {
                    onSuccess(response.body()!!.data)
                }
            } else {
                onError("Fetching error")
            }

        } catch (e: HttpException) {
            onError(e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: IOException) {
            onError(e.localizedMessage ?: "Couldn't reach server. Check your internet connection.")
        }
    }

}