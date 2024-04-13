package com.ortega.tshombo.feature.home.di

import com.ortega.tshombo.core.secret.AppSecret
import com.ortega.tshombo.feature.auth.data.datasources.remote.AuthRemoteDataSource
import com.ortega.tshombo.feature.home.data.datasources.remote.HomeRemoteDataSource
import com.ortega.tshombo.feature.home.data.repository.HomeRepository
import com.ortega.tshombo.feature.home.domain.repository.IHomeRepository
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
object HomeModule {

    @Provides
    @Singleton
    fun provideHomeRemoteDataSource(okHttpClient: OkHttpClient): HomeRemoteDataSource {
        return Retrofit
            .Builder()
            .client(okHttpClient)
            .baseUrl(AppSecret.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HomeRemoteDataSource::class.java)
    }

    @Provides
    @Singleton
    fun provideHomeRepository(homeRemoteDataSource: HomeRemoteDataSource): IHomeRepository {
        return HomeRepository(homeRemoteDataSource)
    }


}