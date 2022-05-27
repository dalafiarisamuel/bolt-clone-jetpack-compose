package ng.devtamuno.bolt.cache.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ng.devtamuno.bolt.cache.room.model.RecentLocationCacheModel

@Dao
interface RecentLocationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveRecentLocation(location: RecentLocationCacheModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveRecentLocations(locations: List<RecentLocationCacheModel>)

    @Query("SELECT * FROM `recent_location`")
    fun getAllRecentLocations(): Flow<List<RecentLocationCacheModel>>

    @Query("DELETE FROM `recent_location`")
    suspend fun cleanTable()
}