package ng.devtamuno.bolt.remote.api

import ng.devtamuno.bolt.remote.model.DebitCardsRemoteResponse
import ng.devtamuno.bolt.remote.model.WalletRemoteResponse
import retrofit2.http.GET

interface WalletService {

    @GET("/user-linked-cards")
    suspend fun getAllLinkedDebitCards(): DebitCardsRemoteResponse

    @GET("/user-wallet")
    suspend fun getWallet(): WalletRemoteResponse
}