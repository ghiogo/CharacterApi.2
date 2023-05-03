package com.example.characterapi2.models

import com.google.gson.annotations.SerializedName

data class Response<T>(

    @SerializedName("results")
    val results: ArrayList<T>
)