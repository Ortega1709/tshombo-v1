package com.ortega.tshombo.feature.myStore.domain.useCase

import com.ortega.tshombo.core.utils.PreferencesManager
import com.ortega.tshombo.feature.myStore.domain.entity.StoreEntity
import com.ortega.tshombo.feature.myStore.domain.repository.IMyStoreRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetStore @Inject constructor(
    private val iMyStoreRepository: IMyStoreRepository,
    private val preferencesManager: PreferencesManager
) {

    suspend operator fun invoke(
        onSuccess: (StoreEntity) -> Unit,
        onError: (String) -> Unit
    ) {
        try {
            val userId = preferencesManager.getData("userId", "")
            if (userId != "") {
                val response = iMyStoreRepository.getStoreByUserId(userId.toInt())
                if (response.code() == 200) {
                    if (response.body() != null) {
                        onSuccess(response.body()!!.data)
                    }
                } else {
                    onError("Fetching error")
                }
            } else {
                onError("Not have a store")
            }

        } catch (e: HttpException) {
            onError(e.localizedMessage ?: "An unexpected error occurred")
        } catch (e: IOException) {
            onError(e.localizedMessage ?: "Couldn't reach server. Check your internet connection.")
        }
    }

}