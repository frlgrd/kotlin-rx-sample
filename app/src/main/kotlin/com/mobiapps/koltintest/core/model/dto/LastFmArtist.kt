package com.mobiapps.koltintest.core.model.dto

import com.google.gson.annotations.SerializedName

class LastFmArtist(
        val name: String,
        val mbid: String?,
        @SerializedName("image") val images: List<LastFmImage>? = null
)
