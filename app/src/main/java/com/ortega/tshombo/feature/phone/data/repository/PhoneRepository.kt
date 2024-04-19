package com.ortega.tshombo.feature.phone.data.repository

import com.ortega.tshombo.core.common.response.Res
import com.ortega.tshombo.feature.phone.data.datasource.remote.PhoneRemoteDataSource
import com.ortega.tshombo.feature.phone.domain.entity.PhoneEntity
import com.ortega.tshombo.feature.phone.domain.repository.IPhoneRepository
import retrofit2.Response
import javax.inject.Inject

class PhoneRepository @Inject constructor(private val phoneRemoteDataSource: PhoneRemoteDataSource): IPhoneRepository {
    override suspend fun getPhoneById(phoneId: Int): Response<Res<PhoneEntity>> {
        return phoneRemoteDataSource.getPhoneById(phoneId)
    }

}