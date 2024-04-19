package com.ortega.tshombo.feature.myStore.domain.useCase

import com.ortega.tshombo.feature.myStore.domain.repository.IMyStoreRepository
import com.ortega.tshombo.feature.myStore.domain.request.PhoneRequest
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class UpdatePhone @Inject constructor(private val iMyStoreRepository: IMyStoreRepository) {

    suspend operator fun invoke(
        storeId: Int,
        phoneRequest: PhoneRequest,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        try {
            val response = iMyStoreRepository.updatePhoneById(storeId, phoneRequest)
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