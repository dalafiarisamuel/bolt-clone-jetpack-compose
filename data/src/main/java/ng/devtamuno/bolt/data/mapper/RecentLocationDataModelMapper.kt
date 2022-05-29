package ng.devtamuno.bolt.data.mapper

import ng.devtamuno.bolt.data.model.RecentLocationDataModel
import ng.devtamuno.bolt.domain.model.RecentLocationDomainModel
import javax.inject.Inject

class RecentLocationDataModelMapper @Inject constructor() :
    DataModelMapper<RecentLocationDataModel, RecentLocationDomainModel>() {
    override fun mapFromDataModel(dataModel: RecentLocationDataModel): RecentLocationDomainModel {
        return with(dataModel) {
            RecentLocationDomainModel(id, label, address, isWorkAddress, isHouseAddress)
        }
    }

    override fun mapToDataModel(domainModel: RecentLocationDomainModel): RecentLocationDataModel {
        return with(domainModel) {
            RecentLocationDataModel(id, label, address, isWorkAddress, isHouseAddress)
        }
    }
}