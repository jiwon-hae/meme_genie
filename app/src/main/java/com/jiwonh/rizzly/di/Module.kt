package com.jiwonh.rizzly.di

import com.jiwonh.rizzly.data.repository.AppLogRepositoryImpl
import com.jiwonh.rizzly.data.repository.LlamaRepositoryImpl
import com.jiwonh.rizzly.domain.repository.AppLogRepository
import com.jiwonh.rizzly.domain.repository.LlamaRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindLlamaRepository(
        impl: LlamaRepositoryImpl
    ): LlamaRepository

    @Binds
    @Singleton
    abstract fun bindAppLogRepository(
        impl: AppLogRepositoryImpl
    ): AppLogRepository
}