package com.mobiapps.koltintest.core.model.artist.dto

import com.google.gson.annotations.SerializedName

class LastFmResponse(
        @SerializedName("artistmatches") val foundedArtist: LastFmArtistList?
)