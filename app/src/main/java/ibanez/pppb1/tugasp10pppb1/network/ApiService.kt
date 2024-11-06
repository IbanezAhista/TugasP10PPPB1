package ibanez.pppb1.tugasp10pppb1.network

import ibanez.pppb1.tugasp10pppb1.model.Profile
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    fun getAllUsers(): Call<Profile>
}