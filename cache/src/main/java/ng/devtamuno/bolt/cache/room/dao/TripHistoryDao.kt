package ng.devtamuno.bolt.cache.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ng.devtamuno.bolt.cache.room.model.TripHistoryCacheModel

@Dao
interface TripHistoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTripHistory(tripHistory: TripHistoryCacheModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTripHistories(tripHistories: List<TripHistoryCacheModel>)

    @Query("SELECT * FROM `trip_history`")
    fun getAllTripHistories(): Flow<List<TripHistoryCacheModel>>

    @Query("DELETE FROM `trip_history`")
    suspend fun cleanTable()
}