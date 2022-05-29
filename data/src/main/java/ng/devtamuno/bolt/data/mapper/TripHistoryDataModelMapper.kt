package ng.devtamuno.bolt.data.mapper

import ng.devtamuno.bolt.data.model.TripHistoryDataModel
import ng.devtamuno.bolt.domain.model.TripHistoryDomainModel
import javax.inject.Inject

class TripHistoryDataModelMapper @Inject constructor() :
    DataModelMapper<TripHistoryDataModel, TripHistoryDomainModel>() {
    override fun mapFromDataModel(dataModel: TripHistoryDataModel): TripHistoryDomainModel {
        return with(dataModel) {
            TripHistoryDomainModel(id, address, amount, driverName, tripStatus, createdAt)
        }
    }

    override fun mapToDataModel(domainModel: TripHistoryDomainModel): TripHistoryDataModel {
        return with(domainModel) {
            TripHistoryDataModel(id, address, amount, driverName, tripStatus, createdAt)
        }
    }
}