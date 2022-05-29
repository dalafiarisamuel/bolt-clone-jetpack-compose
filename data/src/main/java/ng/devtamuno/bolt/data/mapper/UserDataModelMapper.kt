package ng.devtamuno.bolt.data.mapper

import ng.devtamuno.bolt.data.model.UserDataModel
import ng.devtamuno.bolt.domain.model.UserDomainModel
import javax.inject.Inject

class UserDataModelMapper @Inject constructor() :
    DataModelMapper<UserDataModel, UserDomainModel>() {
    override fun mapFromDataModel(dataModel: UserDataModel): UserDomainModel {
        return with(dataModel) {
            UserDomainModel(id, firstName, lastName, email, phoneNumber, isEmailVerified)
        }
    }

    override fun mapToDataModel(domainModel: UserDomainModel): UserDataModel {
        return with(domainModel) {
            UserDataModel(id, firstName, lastName, email, phoneNumber, isEmailVerified)
        }
    }
}