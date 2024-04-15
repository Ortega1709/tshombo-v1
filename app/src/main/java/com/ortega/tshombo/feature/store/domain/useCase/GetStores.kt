package com.ortega.tshombo.feature.store.domain.useCase

import com.ortega.tshombo.feature.home.domain.entity.StoreEntity
import com.ortega.tshombo.feature.store.domain.repository.IStoreRepository
import com.ortega.tshombo.feature.user.domain.entity.UserEntity
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetStores @Inject constructor(private val iStoreRepository: IStoreRepository) {

    suspend operator fun invoke(
        onSuccess: (List<StoreEntity>) -> Unit,
        onError: (String) -> Unit
    ) {
        try {
            val response = iStoreRepository.getAllStores()
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