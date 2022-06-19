package ng.devtamuno.bolt.remote.model

data class DebitCardRemote(
    val id: Long,
    val pan: String,
    val expiry: String,
    val cardHolderName: String,
    val isDefault: Boolean
)

data class DebitCardsRemoteResponse(val list: List<DebitCardRemote>)
