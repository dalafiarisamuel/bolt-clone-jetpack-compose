package ng.devtamuno.bolt.remote.model


data class RecentLocationRemote(
    val id: Long,
    val label: String,
    val address: String,
    val isWorkAddress: Boolean,
    val isHouseAddress: Boolean
)


data class RecentLocationsRemoteResponse(val list: List<RecentLocationRemote>)

data class RecentLocationRemoteResponse(val location: RecentLocationRemote)