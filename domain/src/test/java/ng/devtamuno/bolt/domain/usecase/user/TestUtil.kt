package ng.devtamuno.bolt.domain.usecase.user

import ng.devtamuno.bolt.domain.model.UserDomainModel

object TestUtil {


    fun createUser(
        id: Long? = null,
        firstName: String = "James",
        lastName: String = "John",
        email: String = "james@gmail.com",
        phoneNumber: String = "+23498989345",
        isEmailVerified: Boolean = false

    ): UserDomainModel {
        return UserDomainModel(
            id,
            firstName,
            lastName,
            email,
            phoneNumber,
            isEmailVerified
        )
    }
}
