package com.ortega.tshombo.feature.promotion.di

import com.ortega.tshombo.core.secret.AppSecret
import com.ortega.tshombo.feature.promotion.data.datasources.remote.PromotionRemoteDataSource
import com.ortega.tshombo.feature.promotion.data.repository.PromotionRepository
import com.ortega.tshombo.feature.promotion.domain.repository.IPromotionRepository
import com.ortega.tshombo.feature.store.data.datasources.remote.StoreRemoteDataSource
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
object PromotionModule {

    @Provides
    @Singleton
    fun providePromotionRemoteDataSource(okHttpClient: OkHttpClient): PromotionRemoteDataSource {
        return Retrofit
            .Builder()
            .client(okHttpClient)
            .baseUrl(AppSecret.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PromotionRemoteDataSource::class.java)
    }

    @Provides
    @Singleton
    fun providePromotionRepository(promotionRemoteDataSource: PromotionRemoteDataSource): IPromotionRepository {
        return PromotionRepository(promotionRemoteDataSource)
    }

}