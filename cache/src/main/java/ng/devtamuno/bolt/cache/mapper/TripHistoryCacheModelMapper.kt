package ng.devtamuno.bolt.cache.mapper

import ng.devtamuno.bolt.cache.room.model.TripHistoryCacheModel
import ng.devtamuno.bolt.data.model.TripHistoryDataModel
import javax.inject.Inject

class TripHistoryCacheModelMapper @Inject constructor() :
    CacheModelMapper<TripHistoryCacheModel, TripHistoryDataModel> {
    override fun mapToEntity(model: TripHistoryCacheModel): TripHistoryDataModel {
        return with(model) {
            TripHistoryDataModel(id, address, amount, driverName, tripStatus, createdAt)
        }
    }

    override fun mapToModel(entity: TripHistoryDataModel): TripHistoryCacheModel {
        return with(entity) {
            TripHistoryCacheModel(id, address, amount, driverName, tripStatus, createdAt)
        }
    }

}