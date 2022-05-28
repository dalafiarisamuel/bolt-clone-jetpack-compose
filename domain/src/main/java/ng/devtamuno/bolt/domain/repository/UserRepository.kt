package ng.devtamuno.bolt.domain.repository

import kotlinx.coroutines.flow.Flow
import ng.devtamuno.bolt.domain.model.UserDomainModel

interface UserRepository {

    suspend fun saveUserCache(user: UserDomainModel)

    fun getUserCache(): Flow<List<UserDomainModel>>

    suspend fun cleanUserCacheTable()
}