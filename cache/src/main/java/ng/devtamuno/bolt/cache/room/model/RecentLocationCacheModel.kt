package ng.devtamuno.bolt.cache.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recent_location")
data class RecentLocationCacheModel(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val label: String,
    val address: String,
    val isWorkAddress: Boolean,
    val isHouseAddress: Boolean
)
