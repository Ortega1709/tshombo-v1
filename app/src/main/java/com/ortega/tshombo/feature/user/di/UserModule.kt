package com.ortega.tshombo.feature.user.di

import com.ortega.tshombo.core.secret.AppSecret
import com.ortega.tshombo.feature.auth.data.datasources.remote.AuthRemoteDataSource
import com.ortega.tshombo.feature.user.data.datasources.remote.UserRemoteDataSource
import com.ortega.tshombo.feature.user.data.repository.UserRepository
import com.ortega.tshombo.feature.user.domain.repository.IUserRepository
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
object UserModule {

    @Provides
    @Singleton
    fun provideUserRemoteDataSource(okHttpClient: OkHttpClient): UserRemoteDataSource {
        return Retrofit
            .Builder()
            .client(okHttpClient)
            .baseUrl(AppSecret.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserRemoteDataSource::class.java)
    }

    @Provides
    @Singleton
    fun provideUserRepository(userRemoteDataSource: UserRemoteDataSource): IUserRepository {
        return UserRepository(userRemoteDataSource)
    }
}