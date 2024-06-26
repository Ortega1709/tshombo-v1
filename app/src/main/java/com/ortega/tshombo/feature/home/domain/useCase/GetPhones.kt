package com.ortega.tshombo.feature.home.domain.useCase

import android.util.Log
import com.ortega.tshombo.feature.home.data.repository.HomeRepository
import com.ortega.tshombo.feature.home.domain.entity.PhoneEntity
import com.ortega.tshombo.feature.home.domain.entity.StoreEntity
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPhones @Inject constructor(private val iHomeRepository: HomeRepository) {

    suspend operator fun invoke(
        onSuccess: (List<PhoneEntity>) -> Unit,
        onError: (String) -> Unit
    ) {
        try {
            val response = iHomeRepository.getAllPhones()
            if (response.code() == 200) {
                if (response.body() != null) {
                    onSuccess(response.body()!!.data)
                    Log.d("GET PHONES", response.body()!!.data.toString())
                }
            } else {
                onError("Fetching error")
                Log.d("GET PHONES", "Fetching error")
            }

        } catch (e: HttpException) {
            onError(e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: IOException) {
            onError(e.localizedMessage ?: "Couldn't reach server. Check your internet connection.")
        }
    }

}