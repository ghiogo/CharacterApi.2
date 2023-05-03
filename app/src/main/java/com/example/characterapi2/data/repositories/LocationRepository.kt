package com.example.characterapi2.data.repositories

import com.example.characterapi2.data.remote.apiservice.LocationApiService
import com.example.characterapi2.models.LocationModel
import com.example.characterapi2.models.Response
import com.example.characterapi2.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class LocationRepository @Inject constructor(
    private val locationApiService: LocationApiService
) {
    fun fetchLocation(): Flow<Resource<Response<LocationModel>>> = flow {
        emit(Resource.Loading())
        val fetchLocation = locationApiService.fetchLocation()
        emit(Resource.Success(fetchLocation))
    }.flowOn(Dispatchers.IO).catch {
        emit(Resource.Error(it.localizedMessage ?: "Error!", null))
    }
}