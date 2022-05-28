package ng.devtamuno.bolt.data.model


data class RecentLocationDataModel(
    val id: Long?,
    val label: String,
    val address: String,
    val isWorkAddress: Boolean,
    val isHouseAddress: Boolean
)
