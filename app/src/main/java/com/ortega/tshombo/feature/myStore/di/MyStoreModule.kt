package com.ortega.tshombo.feature.myStore.di

import com.ortega.tshombo.core.secret.AppSecret
import com.ortega.tshombo.feature.auth.data.datasources.remote.AuthRemoteDataSource
import com.ortega.tshombo.feature.myStore.data.datasources.remote.MyStoreRemoteDataSource
import com.ortega.tshombo.feature.myStore.data.repository.MyStoreRepository
import com.ortega.tshombo.feature.myStore.domain.repository.IMyStoreRepository
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
object MyStoreModule {

    @Provides
    @Singleton
    fun provideMyStoreRemoteDataSource(okHttpClient: OkHttpClient): MyStoreRemoteDataSource {
        return Retrofit
            .Builder()
            .client(okHttpClient)
            .baseUrl(AppSecret.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyStoreRemoteDataSource::class.java)
    }

    @Provides
    @Singleton
    fun provideMyStoreRepository(myStoreRemoteDataSource: MyStoreRemoteDataSource): IMyStoreRepository {
        return MyStoreRepository(myStoreRemoteDataSource)
    }

}