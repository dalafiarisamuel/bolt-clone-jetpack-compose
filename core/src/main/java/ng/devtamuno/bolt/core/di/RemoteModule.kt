package ng.devtamuno.bolt.core.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ng.devtamuno.bolt.remote.BuildConfig
import ng.devtamuno.bolt.remote.api.RecentLocationService
import ng.devtamuno.bolt.remote.api.TripHistoryService
import ng.devtamuno.bolt.remote.api.UserService
import ng.devtamuno.bolt.remote.api.WalletService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {


    @[Provides Singleton]
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
        return logging
    }


    @[Provides Singleton]
    fun provideRetrofit(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): Retrofit {

        val okHttpBuilder = OkHttpClient.Builder()
            .cache(null)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .build()

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        return Retrofit.Builder()
            .baseUrl("http://0.0.0.0:8080")
            .client(okHttpBuilder)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @[Provides Singleton]
    fun provideUserService(retrofit: Retrofit): UserService {
        return retrofit.create(UserService::class.java)
    }

    @[Provides Singleton]
    fun provideTripHistoryService(retrofit: Retrofit): TripHistoryService {
        return retrofit.create(TripHistoryService::class.java)
    }

    @[Provides Singleton]
    fun provideWalletService(retrofit: Retrofit): WalletService {
        return retrofit.create(WalletService::class.java)
    }

    @[Provides Singleton]
    fun provideRecentLocationService(retrofit: Retrofit): RecentLocationService {
        return retrofit.create(RecentLocationService::class.java)
    }


}