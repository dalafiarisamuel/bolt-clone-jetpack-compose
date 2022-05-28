package ng.devtamuno.bolt.domain.repository

import kotlinx.coroutines.flow.Flow
import ng.devtamuno.bolt.domain.model.TripHistoryDomainModel

interface TripHistoryRepository {

    suspend fun saveTripHistoryCache(tripHistory: TripHistoryDomainModel)

    suspend fun saveTripHistoriesCache(tripHistories: List<TripHistoryDomainModel>)

    fun getAllTripHistoriesCache(): Flow<List<TripHistoryDomainModel>>

    suspend fun cleanTripHistoryCacheTable()
}