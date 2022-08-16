package ng.devtamuno.bolt.cache.room.util

import ng.devtamuno.bolt.cache.room.model.RecentLocationCacheModel
import ng.devtamuno.bolt.cache.room.model.TripHistoryCacheModel
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

    fun createTripHistory(
        id: Long? = null,
        address: String = "12, Ajibola street",
        amount: Double = 1_500.00,
        driverName: String = "John Cena",
        tripStatus: String = "CANCELLED",
        createdAt: String = "12-30-2022"
    ): TripHistoryCacheModel {
        return TripHistoryCacheModel(
            id,
            address,
            amount,
            driverName,
            tripStatus,
            createdAt
        )
    }
}
