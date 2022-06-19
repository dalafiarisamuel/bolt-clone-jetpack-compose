package ng.devtamuno.bolt.remote.model

data class TripHistoryRemote(
    val id: Long,
    val address: String,
    val amount: Double,
    val driverName: String,
    val tripStatus: String,
    val createdAt: String
)

data class TripHistoriesRemoteResponse(val list: List<TripHistoryRemote>)

data class TripHistoryRemoteResponse(val tripHistory: TripHistoryRemote)
