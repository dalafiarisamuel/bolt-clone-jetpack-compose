package ng.devtamuno.bolt.cache.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ng.devtamuno.bolt.cache.mapper.UserCacheModelMapper
import ng.devtamuno.bolt.cache.room.dao.UserDao
import ng.devtamuno.bolt.data.contract.user.cache.UserCache
import ng.devtamuno.bolt.data.model.UserDataModel
import javax.inject.Inject

class UserCacheImpl @Inject constructor(
    private val dao: UserDao,
    private val userCacheModelMapper: UserCacheModelMapper
) : UserCache {
    override suspend fun saveUser(user: UserDataModel) {
        dao.saveUser(userCacheModelMapper.mapToModel(user))
    }

    override fun getUser(): Flow<List<UserDataModel>> {
        return dao.getUser().map {
            userCacheModelMapper.mapToEntityList(it)
        }
    }

    override suspend fun cleanTable() {
        dao.cleanTable()
    }
}