package ng.devtamuno.bolt.remote.api

import ng.devtamuno.bolt.remote.model.UserRemoteResponse
import retrofit2.http.GET

interface UserService {

    @GET("/get-user")
    suspend fun getUser(): UserRemoteResponse
}