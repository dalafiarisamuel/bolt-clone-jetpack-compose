package ng.devtamuno.bolt.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ng.devtamuno.bolt.data.contract.triphistory.cache.TripHistoryCache
import ng.devtamuno.bolt.data.mapper.TripHistoryDataModelMapper
import ng.devtamuno.bolt.domain.model.TripHistoryDomainModel
import ng.devtamuno.bolt.domain.repository.TripHistoryRepository
import javax.inject.Inject

class TripHistoryRepositoryImpl @Inject constructor(
    private val cache: TripHistoryCache,
    private val mapper: TripHistoryDataModelMapper
) : TripHistoryRepository {
    override suspend fun saveTripHistoryCache(tripHistory: TripHistoryDomainModel) {
        cache.saveTripHistory(mapper.mapToDataModel(tripHistory))
    }

    override suspend fun saveTripHistoriesCache(tripHistories: List<TripHistoryDomainModel>) {
        cache.saveTripHistories(mapper.mapFromDomainList(tripHistories))
    }

    override fun getAllTripHistoriesCache(): Flow<List<TripHistoryDomainModel>> {
        return cache.getAllTripHistories().map {
            mapper.mapFromDataList(it)
        }
    }

    override suspend fun cleanTripHistoryCacheTable() {
        cache.cleanTable()
    }
}