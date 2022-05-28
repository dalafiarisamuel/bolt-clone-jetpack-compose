package ng.devtamuno.bolt.cache.mapper

import ng.devtamuno.bolt.cache.room.model.RecentLocationCacheModel
import ng.devtamuno.bolt.data.model.RecentLocationDataModel
import javax.inject.Inject

class RecentLocationCacheModelMapper @Inject constructor() :
    CacheModelMapper<RecentLocationCacheModel, RecentLocationDataModel> {
    override fun mapToEntity(model: RecentLocationCacheModel): RecentLocationDataModel {
        return with(model) {
            RecentLocationDataModel(id, label, address, isWorkAddress, isHouseAddress)
        }
    }

    override fun mapToModel(entity: RecentLocationDataModel): RecentLocationCacheModel {
        return with(entity) {
            RecentLocationCacheModel(id, label, address, isWorkAddress, isHouseAddress)
        }
    }

}