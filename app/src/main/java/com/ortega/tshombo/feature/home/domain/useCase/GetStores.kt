package com.ortega.tshombo.feature.home.domain.useCase

import android.util.Log
import com.ortega.tshombo.feature.auth.domain.entity.UserEntity
import com.ortega.tshombo.feature.home.data.repository.HomeRepository
import com.ortega.tshombo.feature.home.domain.entity.StoreEntity
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetStores @Inject constructor(private val iHomeRepository: HomeRepository) {

    suspend operator fun invoke(
        onSuccess: (List<StoreEntity>) -> Unit,
        onError: (String) -> Unit
    ) {
        try {
            val response = iHomeRepository.getAllStores()
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