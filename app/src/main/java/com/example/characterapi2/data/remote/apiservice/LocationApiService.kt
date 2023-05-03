package com.example.characterapi2.data.remote.apiservice

import com.example.characterapi2.models.LocationModel
import com.example.characterapi2.models.Response
import retrofit2.http.GET

interface LocationApiService {

    @GET("api/location")
    suspend fun fetchLocation(
    ): Response<LocationModel>
}