package ng.devtamuno.bolt.data.contract.user.cache

import kotlinx.coroutines.flow.Flow
import ng.devtamuno.bolt.data.model.UserDataModel

interface UserCache {

    suspend fun saveUser(user: UserDataModel)

    fun getUser(): Flow<List<UserDataModel>>

    suspend fun cleanTable()

}