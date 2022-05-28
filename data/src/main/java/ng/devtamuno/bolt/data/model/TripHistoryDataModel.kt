package ng.devtamuno.bolt.data.model


data class TripHistoryDataModel(
    val id: Long?,
    val address: String,
    val amount: Double,
    val driverName: String,
    val tripStatus: String,
    val createdAt: String
)
