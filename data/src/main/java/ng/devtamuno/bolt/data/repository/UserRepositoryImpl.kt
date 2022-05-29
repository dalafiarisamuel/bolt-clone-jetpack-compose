package ng.devtamuno.bolt.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ng.devtamuno.bolt.data.contract.user.cache.UserCache
import ng.devtamuno.bolt.data.mapper.UserDataModelMapper
import ng.devtamuno.bolt.domain.model.UserDomainModel
import ng.devtamuno.bolt.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val cache: UserCache,
    private val mapper: UserDataModelMapper
) : UserRepository {
    override suspend fun saveUserCache(user: UserDomainModel) {
        cache.saveUser(mapper.mapToDataModel(user))
    }

    override fun getUserCache(): Flow<List<UserDomainModel>> {
        return cache.getUser().map {
            mapper.mapFromDataList(it)
        }
    }

    override suspend fun cleanUserCacheTable() {
        cache.cleanTable()
    }
}