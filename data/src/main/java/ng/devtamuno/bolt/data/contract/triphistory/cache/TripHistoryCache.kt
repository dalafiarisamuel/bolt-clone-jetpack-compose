package ng.devtamuno.bolt.data.contract.triphistory.cache

import kotlinx.coroutines.flow.Flow
import ng.devtamuno.bolt.data.model.TripHistoryDataModel

interface TripHistoryCache {

    suspend fun saveTripHistory(tripHistory: TripHistoryDataModel)

    suspend fun saveTripHistories(tripHistories: List<TripHistoryDataModel>)

    fun getAllTripHistories(): Flow<List<TripHistoryDataModel>>

    suspend fun cleanTable()
}