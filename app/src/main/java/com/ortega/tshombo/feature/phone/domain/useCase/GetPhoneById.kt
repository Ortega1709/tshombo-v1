package com.ortega.tshombo.feature.phone.domain.useCase


import com.ortega.tshombo.feature.phone.domain.entity.PhoneEntity
import com.ortega.tshombo.feature.phone.domain.repository.IPhoneRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class GetPhoneById @Inject constructor(private val iPhoneRepository: IPhoneRepository) {

    suspend operator fun invoke(
        phoneId: Int,
        onSuccess: (PhoneEntity) -> Unit,
        onError: (String) -> Unit
    ) {
        try {
            val response = iPhoneRepository.getPhoneById(phoneId)
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