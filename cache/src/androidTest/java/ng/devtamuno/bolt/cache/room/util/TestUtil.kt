package ng.devtamuno.bolt.cache.room.util

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import ng.devtamuno.bolt.cache.room.model.RecentLocationCacheModel
import ng.devtamuno.bolt.cache.room.model.UserCacheModel

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

    fun createUser(
        id: Long? = null,
        firstName: String = "Samuel",
        lastName: String = "Peterson",
        email: String = "samuelpeterson@12mail.com",
        phoneNumber: String = "+23408923453",
        isEmailVerified: Boolean = false
    ): UserCacheModel {
        return UserCacheModel(
            id,
            firstName,
            lastName,
            email,
            phoneNumber,
            isEmailVerified
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