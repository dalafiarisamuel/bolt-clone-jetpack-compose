package ng.devtamuno.bolt.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ng.devtamuno.bolt.data.repository.RecentLocationRepositoryImpl
import ng.devtamuno.bolt.data.repository.TripHistoryRepositoryImpl
import ng.devtamuno.bolt.data.repository.UserRepositoryImpl
import ng.devtamuno.bolt.domain.repository.RecentLocationRepository
import ng.devtamuno.bolt.domain.repository.TripHistoryRepository
import ng.devtamuno.bolt.domain.repository.UserRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @[Provides Singleton]
    fun providesRecentLocationRepository(repository: RecentLocationRepositoryImpl):
            RecentLocationRepository = repository

    @[Provides Singleton]
    fun providesTripHistoryRepository(repository: TripHistoryRepositoryImpl):
            TripHistoryRepository = repository


    @[Provides Singleton]
    fun providesUserRepository(repository: UserRepositoryImpl):
            UserRepository = repository
}