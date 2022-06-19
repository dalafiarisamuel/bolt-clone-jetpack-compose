package ng.devtamuno.bolt.remote.model


data class UserRemote(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phoneNumber: String,
    val isEmailVerified: Boolean
)


data class UserRemoteResponse(val user: UserRemote)
