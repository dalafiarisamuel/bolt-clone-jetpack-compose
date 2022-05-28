package ng.devtamuno.bolt.domain.model


data class RecentLocationDomainModel(
    val id: Long?,
    val label: String,
    val address: String,
    val isWorkAddress: Boolean,
    val isHouseAddress: Boolean
)
