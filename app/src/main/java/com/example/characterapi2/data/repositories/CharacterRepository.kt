package com.example.characterapi2.data.repositories

import com.example.characterapi2.data.remote.apiservice.CharacterApiService
import com.example.characterapi2.models.CharacterModel
import com.example.characterapi2.models.Response
import com.example.characterapi2.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val characterApiService: CharacterApiService
) {
    fun fetchCharacter(): Flow<Resource<Response<CharacterModel>>> = flow {
        emit(Resource.Loading())
        val fetchCharacter = characterApiService.fetchCharacters()
        emit(Resource.Success(fetchCharacter))
    }.flowOn(Dispatchers.IO).catch {
        emit(Resource.Error(it.localizedMessage ?: "Error!", null))
    }
}