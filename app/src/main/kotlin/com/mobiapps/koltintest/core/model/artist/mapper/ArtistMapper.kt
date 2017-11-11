package com.mobiapps.koltintest.core.model.artist.mapper

import com.mobiapps.koltintest.App
import com.mobiapps.koltintest.core.model.artist.Artist
import com.mobiapps.koltintest.core.model.artist.dto.LastFmArtist
import javax.inject.Inject

class ArtistMapper {

    @Inject lateinit var imageMapper: ImageMapper

    init {
        App.deps.inject(this)
    }

    fun transform(artists: List<LastFmArtist?>?): List<Artist> {
        return artists?.filter { it != null && artistHasQualityInfo(it) }?.mapNotNull { transformArtist(it as LastFmArtist) } ?: emptyList()
    }

    private fun transformArtist(artist: LastFmArtist) = artist.mbid?.let {
        Artist(artist.mbid, artist.name, imageMapper.getMainImageUrl(artist.images))
    }

    private fun artistHasQualityInfo(it: LastFmArtist): Boolean {
        return !isArtistMbidEmpty(it) && it.images != null && it.images.isNotEmpty()
    }

    private fun isArtistMbidEmpty(artist: LastFmArtist): Boolean = artist.mbid.let { it != null && it.isEmpty() }
}