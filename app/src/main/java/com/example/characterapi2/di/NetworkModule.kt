package com.example.characterapi2.di

import com.example.characterapi2.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    private val retrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun fetchLocation() = retrofitClient.provideLocationApiService()

    @Singleton
    @Provides
    fun fetchCharacter() = retrofitClient.provideCharacterApiService()
}