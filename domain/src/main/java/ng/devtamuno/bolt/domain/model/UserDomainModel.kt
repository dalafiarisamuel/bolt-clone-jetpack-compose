package ng.devtamuno.bolt.domain.model


data class UserDomainModel(
    val id: Long?,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phoneNumber: String,
    val isEmailVerified: Boolean
)
