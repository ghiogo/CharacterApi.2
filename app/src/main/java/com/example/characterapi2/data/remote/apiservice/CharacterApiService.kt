package com.example.characterapi2.data.remote.apiservice

import com.example.characterapi2.models.CharacterModel
import com.example.characterapi2.models.Response
import retrofit2.http.GET

interface CharacterApiService {

    @GET("api/character")
    suspend fun fetchCharacters(
    ): Response<CharacterModel>
}