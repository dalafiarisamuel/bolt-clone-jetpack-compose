package ng.devtamuno.bolt.remote.api

import ng.devtamuno.bolt.remote.model.TripHistoriesRemoteResponse
import ng.devtamuno.bolt.remote.model.TripHistoryRemoteResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TripHistoryService {

    @GET("/trip-histories")
    suspend fun getTripHistories(): TripHistoriesRemoteResponse

    suspend fun getTripHistoryById(@Query("id") id: Long): TripHistoryRemoteResponse
}