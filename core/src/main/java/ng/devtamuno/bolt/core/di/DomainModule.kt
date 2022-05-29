package ng.devtamuno.bolt.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ng.devtamuno.bolt.core.executors.CoroutinePostDispatchersImpl
import ng.devtamuno.bolt.domain.executor.CoroutinePostDispatchers
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {

    @[Provides Singleton]
    fun providesCoroutinePostDispatchers(dispatchers: CoroutinePostDispatchersImpl): CoroutinePostDispatchers =
        dispatchers
}