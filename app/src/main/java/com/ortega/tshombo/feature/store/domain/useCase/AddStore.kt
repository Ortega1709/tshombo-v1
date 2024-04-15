package com.ortega.tshombo.feature.store.domain.useCase

import com.ortega.tshombo.feature.store.domain.repository.IStoreRepository
import com.ortega.tshombo.feature.store.domain.request.StoreRequest
import com.ortega.tshombo.feature.user.domain.request.UserRequest
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class AddStore @Inject constructor(private val iStoreRepository: IStoreRepository) {

    suspend operator fun invoke(
        userId: Int,
        storeRequest: StoreRequest,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        try {
            val response = iStoreRepository.addStore(userId = userId, storeRequest = storeRequest)
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