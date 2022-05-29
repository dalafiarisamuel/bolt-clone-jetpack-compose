package ng.devtamuno.bolt.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ng.devtamuno.bolt.data.contract.recentlocation.cache.RecentLocationCache
import ng.devtamuno.bolt.data.mapper.RecentLocationDataModelMapper
import ng.devtamuno.bolt.domain.model.RecentLocationDomainModel
import ng.devtamuno.bolt.domain.repository.RecentLocationRepository
import javax.inject.Inject

class RecentLocationRepositoryImpl @Inject constructor(
    private val cache: RecentLocationCache,
    private val mapper: RecentLocationDataModelMapper
) : RecentLocationRepository {
    override suspend fun saveRecentLocationCache(location: RecentLocationDomainModel) {
        cache.saveRecentLocation(mapper.mapToDataModel(location))
    }

    override suspend fun saveRecentLocationsCache(locations: List<RecentLocationDomainModel>) {
        cache.saveRecentLocations(mapper.mapFromDomainList(locations))
    }

    override fun getAllRecentLocationsCache(): Flow<List<RecentLocationDomainModel>> {
        return cache.getAllRecentLocations().map {
            mapper.mapFromDataList(it)
        }
    }

    override suspend fun cleanRecentLocationCacheTable() {
        cache.cleanTable()
    }
}