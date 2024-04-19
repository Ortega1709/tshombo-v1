package com.ortega.tshombo.feature.phone.di

import com.ortega.tshombo.core.secret.AppSecret
import com.ortega.tshombo.feature.myStore.data.datasources.remote.MyStoreRemoteDataSource
import com.ortega.tshombo.feature.phone.data.datasource.remote.PhoneRemoteDataSource
import com.ortega.tshombo.feature.phone.data.repository.PhoneRepository
import com.ortega.tshombo.feature.phone.domain.repository.IPhoneRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PhoneModule {

    @Provides
    @Singleton
    fun providePhoneRemoteDataSource(okHttpClient: OkHttpClient): PhoneRemoteDataSource {
        return Retrofit
            .Builder()
            .client(okHttpClient)
            .baseUrl(AppSecret.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PhoneRemoteDataSource::class.java)
    }

    @Provides
    @Singleton
    fun providePhoneRepository(phoneRemoteDataSource: PhoneRemoteDataSource): IPhoneRepository {
        return PhoneRepository(phoneRemoteDataSource)
    }

}