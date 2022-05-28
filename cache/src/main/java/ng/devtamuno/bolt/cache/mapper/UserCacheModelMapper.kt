package ng.devtamuno.bolt.cache.mapper

import ng.devtamuno.bolt.cache.room.model.UserCacheModel
import ng.devtamuno.bolt.data.model.UserDataModel
import javax.inject.Inject

class UserCacheModelMapper @Inject constructor() : CacheModelMapper<UserCacheModel, UserDataModel> {

    override fun mapToEntity(model: UserCacheModel): UserDataModel {
        return with(model) {
            UserDataModel(id, firstName, lastName, email, phoneNumber, isEmailVerified)
        }
    }

    override fun mapToModel(entity: UserDataModel): UserCacheModel {
        return with(entity) {
            UserCacheModel(id, firstName, lastName, email, phoneNumber, isEmailVerified)
        }
    }
}