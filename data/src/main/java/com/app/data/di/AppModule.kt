package com.app.data.di

import com.app.common.AppCons.BASE_URL
import com.app.data.remote.UserApiService
import com.app.domain.repository.UserRepository
import com.app.domain.usecase.GetUserListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUserApi(): UserApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApiService::class.java)
    }

    @Provides
    fun provideGetUserListUseCase(repository: UserRepository): GetUserListUseCase {
        return GetUserListUseCase(repository)
    }

}
