package com.ortega.tshombo.feature.myStore.domain.useCase

import com.ortega.tshombo.feature.myStore.domain.repository.IMyStoreRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class DeletePhone @Inject constructor(private val iMyStoreRepository: IMyStoreRepository) {

    suspend operator fun invoke(
        phoneId: Int,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        try {
            val response = iMyStoreRepository.deletePhoneById(phoneId)
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