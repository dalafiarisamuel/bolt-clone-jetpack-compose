package ng.devtamuno.bolt.data.contract.recentlocation.cache

import kotlinx.coroutines.flow.Flow
import ng.devtamuno.bolt.data.model.RecentLocationDataModel

interface RecentLocationCache {

    suspend fun saveRecentLocation(location: RecentLocationDataModel)

    suspend fun saveRecentLocations(locations: List<RecentLocationDataModel>)

    fun getAllRecentLocations(): Flow<List<RecentLocationDataModel>>

    suspend fun cleanTable()
}