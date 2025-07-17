package com.app.domain.usecase

import com.app.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideGetUserListUseCase(repository: UserRepository): GetUserListUseCase {
        return GetUserListUseCase(repository)
    }
}