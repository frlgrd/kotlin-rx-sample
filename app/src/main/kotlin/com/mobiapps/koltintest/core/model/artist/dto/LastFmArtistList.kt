package com.mobiapps.koltintest.core.model.artist.dto

import com.google.gson.annotations.SerializedName

class LastFmArtistList(
        @SerializedName("artist") val artists: List<LastFmArtist>?
)
