package com.ortega.tshombo.feature.phone.domain.repository

import com.ortega.tshombo.core.common.response.Res
import com.ortega.tshombo.feature.phone.domain.entity.PhoneEntity
import retrofit2.Response

interface IPhoneRepository {

    suspend fun getPhoneById(phoneId: Int): Response<Res<PhoneEntity>>

}