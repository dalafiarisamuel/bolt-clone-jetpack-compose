package ng.devtamuno.bolt.domain.model


data class TripHistoryDomainModel(
    val id: Long?,
    val address: String,
    val amount: Double,
    val driverName: String,
    val tripStatus: String,
    val createdAt: String
)
