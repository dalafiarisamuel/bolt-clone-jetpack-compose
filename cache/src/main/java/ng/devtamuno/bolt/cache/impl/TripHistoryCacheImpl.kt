package ng.devtamuno.bolt.cache.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ng.devtamuno.bolt.cache.mapper.TripHistoryCacheModelMapper
import ng.devtamuno.bolt.cache.room.dao.TripHistoryDao
import ng.devtamuno.bolt.data.contract.triphistory.cache.TripHistoryCache
import ng.devtamuno.bolt.data.model.TripHistoryDataModel
import javax.inject.Inject

class TripHistoryCacheImpl @Inject constructor(
    private val dao: TripHistoryDao,
    private val mapper: TripHistoryCacheModelMapper
) : TripHistoryCache {
    override suspend fun saveTripHistory(tripHistory: TripHistoryDataModel) {
        dao.saveTripHistory(mapper.mapToModel(tripHistory))
    }

    override suspend fun saveTripHistories(tripHistories: List<TripHistoryDataModel>) {
        dao.saveTripHistories(mapper.mapToModelList(tripHistories))
    }

    override fun getAllTripHistories(): Flow<List<TripHistoryDataModel>> {
        return dao.getAllTripHistories().map {
            mapper.mapToEntityList(it)
        }
    }

    override suspend fun cleanTable() {
        dao.cleanTable()
    }
}