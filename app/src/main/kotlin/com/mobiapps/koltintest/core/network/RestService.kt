package com.mobiapps.koltintest.core.network

import com.mobiapps.koltintest.core.model.artist.dto.LastFmResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RestService {
    @GET("/2.0/?method=artist.search")
    fun searchArtist(@Query("artist") query: String): Observable<LastFmResult?>
}