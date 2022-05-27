package ng.devtamuno.bolt.cache.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ng.devtamuno.bolt.cache.room.model.UserCacheModel


@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUser(user: UserCacheModel)

    @Query("SELECT * FROM `user` LIMIT 1")
    fun getUser(): Flow<List<UserCacheModel>>

    @Query("DELETE FROM `user`")
    suspend fun cleanTable()
}