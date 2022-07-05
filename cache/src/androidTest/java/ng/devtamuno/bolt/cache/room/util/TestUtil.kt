package ng.devtamuno.bolt.cache.room.util

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import ng.devtamuno.bolt.cache.room.model.RecentLocationCacheModel

object TestUtil {


    fun createRecentLocation(
        id: Long? = null,
        label: String = "Lagos",
        address: String = "12, Ajibola street",
        isHouseAddress: Boolean = false,
        isWorkAddress: Boolean = false
    ): RecentLocationCacheModel {

        return RecentLocationCacheModel(
            id = id,
            label = label,
            address = address,
            isWorkAddress = isWorkAddress,
            isHouseAddress = isHouseAddress
        )
    }


    @ExperimentalCoroutinesApi
    fun executeTest(
        block: suspend () -> Unit
    ) {
        runTest {
            block()
        }
    }
}