package ng.devtamuno.bolt.core.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ng.devtamuno.bolt.cache.impl.RecentLocationCacheImpl
import ng.devtamuno.bolt.cache.impl.TripHistoryCacheImpl
import ng.devtamuno.bolt.cache.impl.UserCacheImpl
import ng.devtamuno.bolt.cache.room.dao.RecentLocationDao
import ng.devtamuno.bolt.cache.room.dao.TripHistoryDao
import ng.devtamuno.bolt.cache.room.dao.UserDao
import ng.devtamuno.bolt.cache.room.database.BoltDatabase
import ng.devtamuno.bolt.data.contract.recentlocation.cache.RecentLocationCache
import ng.devtamuno.bolt.data.contract.user.cache.UserCache
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @[Provides Singleton]
    fun providesDatabase(@ApplicationContext context: Context): BoltDatabase {
        return Room.databaseBuilder(
            context,
            BoltDatabase::class.java,
            "bolt_database"
        ).build()
    }

    @[Provides Singleton]
    fun providesRecentLocationDao(dBClass: BoltDatabase): RecentLocationDao =
        dBClass.recentLocationDao()

    @[Provides Singleton]
    fun providesTripHistoryDao(dBClass: BoltDatabase): TripHistoryDao = dBClass.tripHistoryDao()

    @[Provides Singleton]
    fun providesUserDao(dBClass: BoltDatabase): UserDao = dBClass.userDao()

    @[Provides Singleton]
    fun providesUserCache(impl: UserCacheImpl): UserCache = impl

    @[Provides Singleton]
    fun providesRecentLocationCache(impl: RecentLocationCacheImpl): RecentLocationCache = impl

    @[Provides Singleton]
    fun providesTripHistoryCache(impl: TripHistoryCacheImpl): TripHistoryCacheImpl = impl
}