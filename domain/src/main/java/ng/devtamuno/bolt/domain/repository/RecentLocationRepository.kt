package ng.devtamuno.bolt.domain.repository

import kotlinx.coroutines.flow.Flow
import ng.devtamuno.bolt.domain.model.RecentLocationDomainModel

interface RecentLocationRepository {

    suspend fun saveRecentLocationCache(location: RecentLocationDomainModel)

    suspend fun saveRecentLocationsCache(locations: List<RecentLocationDomainModel>)

    fun getAllRecentLocationsCache(): Flow<List<RecentLocationDomainModel>>

    suspend fun cleanRecentLocationCacheTable()
}