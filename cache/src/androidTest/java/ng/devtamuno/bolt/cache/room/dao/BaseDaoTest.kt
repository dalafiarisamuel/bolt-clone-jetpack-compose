package ng.devtamuno.bolt.cache.room.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import ng.devtamuno.bolt.cache.room.database.BoltDatabase
import java.io.IOException

abstract class BaseDaoTest {

    lateinit var database: BoltDatabase

    open fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(context, BoltDatabase::class.java).build()
    }


    @Throws(IOException::class)
    open fun tearDown() {
        database.close()
    }
}