package ng.devtamuno.bolt.cache.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ng.devtamuno.bolt.cache.room.dao.RecentLocationDao
import ng.devtamuno.bolt.cache.room.dao.TripHistoryDao
import ng.devtamuno.bolt.cache.room.dao.UserDao
import ng.devtamuno.bolt.cache.room.model.RecentLocationCacheModel
import ng.devtamuno.bolt.cache.room.model.TripHistoryCacheModel
import ng.devtamuno.bolt.cache.room.model.UserCacheModel

@Database(
    entities = [
        UserCacheModel::class,
        RecentLocationCacheModel::class,
        TripHistoryCacheModel::class
    ],
    version = 1, exportSchema = false
)
abstract class BoltDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun recentLocationDao(): RecentLocationDao

    abstract fun tripHistoryDao(): TripHistoryDao
}