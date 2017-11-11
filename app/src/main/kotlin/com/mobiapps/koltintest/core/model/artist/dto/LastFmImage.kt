package com.mobiapps.koltintest.core.model.artist.dto

import com.google.gson.annotations.SerializedName

class LastFmImage(
        @SerializedName("#text") val url: String,
        val size: String
)
