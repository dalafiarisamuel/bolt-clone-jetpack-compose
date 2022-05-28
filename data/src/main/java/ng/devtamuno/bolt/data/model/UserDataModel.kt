package ng.devtamuno.bolt.data.model


data class UserDataModel(
    val id: Long?,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phoneNumber: String,
    val isEmailVerified: Boolean
)
