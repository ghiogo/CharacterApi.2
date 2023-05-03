package com.example.characterapi2.models

import com.example.characterapi2.base.IBaseDiffModel

data class CharacterAndLocationModel(
    val character: CharacterModel,
    val location: LocationModel,
    override val id: Int = 0
) : IBaseDiffModel