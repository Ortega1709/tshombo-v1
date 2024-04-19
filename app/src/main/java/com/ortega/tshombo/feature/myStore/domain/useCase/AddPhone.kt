package com.ortega.tshombo.feature.myStore.domain.useCase

import android.util.Log
import com.ortega.tshombo.feature.myStore.domain.entity.PhoneEntity
import com.ortega.tshombo.feature.myStore.domain.repository.IMyStoreRepository
import com.ortega.tshombo.feature.myStore.domain.request.PhoneRequest
import retrofit2.HttpException
import java.io.File
import java.io.IOException
import javax.inject.Inject

class AddPhone @Inject constructor(private val iMyStoreRepository: IMyStoreRepository) {

    suspend operator fun invoke(
        image: File,
        storeId: Int,
        phoneRequest: PhoneRequest,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {

        try {
            val response = iMyStoreRepository.addPhone(
                storeId = storeId,
                phoneRequest = phoneRequest
            )
            if (response.code() == 201) {
                if (response.body() != null) {
                    Log.d("STORE", response.body()!!.data.toString())
                    val phoneEntity: PhoneEntity = response.body()!!.data

                    uploadFile(
                        phoneId = phoneEntity.phoneId,
                        image = image,
                        onSuccess = {
                            onSuccess()
                        },
                        onError = {
                            onError(it)
                        },
                    )
                }
            } else {
                onError("Add error")
            }

        } catch (e: HttpException) {
            onError(e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: IOException) {
            onError(e.localizedMessage ?: "Couldn't reach server. Check your internet connection.")
        }

    }

    private suspend fun uploadFile(
        phoneId: Int,
        image: File,
        onSuccess: () -> Unit,
        onError: (String) -> Unit,
    ) {
        try {
            val response = iMyStoreRepository.uploadFilePhone(phoneId = phoneId, image = image)
            onSuccess()
        } catch (e: HttpException) {
            onError(e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: IOException) {
            onError(e.localizedMessage ?: "Couldn't reach server. Check your internet connection.")
        }
    }

}