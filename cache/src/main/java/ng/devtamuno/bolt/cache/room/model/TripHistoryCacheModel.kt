package ng.devtamuno.bolt.cache.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trip_history")
data class TripHistoryCacheModel(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val address: String,
    val amount: Double,
    val driverName: String,
    val tripStatus: String,
    val createdAt: String
)
