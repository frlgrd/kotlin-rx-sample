package com.mobiapps.koltintest.core.model.dto

import com.google.gson.annotations.SerializedName

class LastFmImage(
        @SerializedName("#text") val url: String,
        val size: String
)
