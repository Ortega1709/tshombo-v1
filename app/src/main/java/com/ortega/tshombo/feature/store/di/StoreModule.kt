package com.ortega.tshombo.feature.store.di

import com.ortega.tshombo.core.secret.AppSecret
import com.ortega.tshombo.feature.auth.data.datasources.remote.AuthRemoteDataSource
import com.ortega.tshombo.feature.store.data.datasources.remote.StoreRemoteDataSource
import com.ortega.tshombo.feature.store.data.repository.StoreRepository
import com.ortega.tshombo.feature.store.domain.repository.IStoreRepository
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
class StoreModule {

    @Provides
    @Singleton
    fun provideStoreRemoteDataSource(okHttpClient: OkHttpClient): StoreRemoteDataSource {
        return Retrofit
            .Builder()
            .client(okHttpClient)
            .baseUrl(AppSecret.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StoreRemoteDataSource::class.java)
    }

    @Provides
    @Singleton
    fun provideStoreRepository(storeRemoteDataSource: StoreRemoteDataSource): IStoreRepository {
        return StoreRepository(storeRemoteDataSource)
    }

}