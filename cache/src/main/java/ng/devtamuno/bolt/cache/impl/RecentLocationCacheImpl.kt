package ng.devtamuno.bolt.cache.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ng.devtamuno.bolt.cache.mapper.RecentLocationCacheModelMapper
import ng.devtamuno.bolt.cache.room.dao.RecentLocationDao
import ng.devtamuno.bolt.data.contract.recentlocation.cache.RecentLocationCache
import ng.devtamuno.bolt.data.model.RecentLocationDataModel
import javax.inject.Inject

class RecentLocationCacheImpl @Inject constructor(
    private val dao: RecentLocationDao,
    private val mapper: RecentLocationCacheModelMapper
) : RecentLocationCache {
    override suspend fun saveRecentLocation(location: RecentLocationDataModel) {
        dao.saveRecentLocation(mapper.mapToModel(location))
    }

    override suspend fun saveRecentLocations(locations: List<RecentLocationDataModel>) {
        dao.saveRecentLocations(mapper.mapToModelList(locations))
    }

    override fun getAllRecentLocations(): Flow<List<RecentLocationDataModel>> {
        return dao.getAllRecentLocations().map {
            mapper.mapToEntityList(it)
        }
    }

    override suspend fun cleanTable() {
        dao.cleanTable()
    }
}