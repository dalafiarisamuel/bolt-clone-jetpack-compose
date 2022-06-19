package ng.devtamuno.bolt.remote.model

data class WalletRemote(
    val balance: Double,
    val currency: String
)

data class WalletRemoteResponse(val wallet: WalletRemote)