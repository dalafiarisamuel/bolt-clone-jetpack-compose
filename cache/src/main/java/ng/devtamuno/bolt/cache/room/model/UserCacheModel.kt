package ng.devtamuno.bolt.cache.room.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index(value = ["phoneNumber", "email"], unique = true)], tableName = "user")
data class UserCacheModel(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phoneNumber: String,
    val isEmailVerified: Boolean
)
