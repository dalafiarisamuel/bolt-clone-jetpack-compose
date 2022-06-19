package ng.devtamuno.bolt.remote.api

import ng.devtamuno.bolt.remote.model.RecentLocationRemoteResponse
import ng.devtamuno.bolt.remote.model.RecentLocationsRemoteResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RecentLocationService {

    @GET("/recent-locations")
    suspend fun getRecentLocations(): RecentLocationsRemoteResponse

    @GET("/recent-locations")
    suspend fun getRecentLocationById(@Query("id") id: Long): RecentLocationRemoteResponse
}