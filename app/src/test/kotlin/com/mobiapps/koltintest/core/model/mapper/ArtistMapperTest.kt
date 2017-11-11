package com.mobiapps.koltintest.core.model.mapper

import com.mobiapps.koltintest.core.model.artist.mapper.ArtistMapper
import com.mobiapps.koltintest.core.model.artist.dto.LastFmArtist
import com.mobiapps.koltintest.core.model.artist.dto.LastFmImage
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class ArtistMapperTest {
    private lateinit var artistMapper: ArtistMapper

    @Before
    fun setup() {
        artistMapper = ArtistMapper()
    }

    @Test
    fun noData() {
        assertEquals(artistMapper.transform(null).size, 0)
    }

    @Test
    fun empty() {
        assertEquals(artistMapper.transform(arrayListOf()).size, 0)
    }

    @Test
    fun filledWithNull() {
        assertEquals(artistMapper.transform(arrayListOf(null, null)).size, 0)
    }

    @Test
    fun filledWithNullAndNotNull() {
        assertEquals(artistMapper.transform(arrayListOf(null, LastFmArtist("", null, null))).size, 0)
        assertEquals(artistMapper.transform(arrayListOf(null, LastFmArtist("", "", null))).size, 0)
        assertEquals(artistMapper.transform(arrayListOf(null, LastFmArtist("", "fake", null))).size, 0)
        assertEquals(artistMapper.transform(arrayListOf(null, LastFmArtist("", "", arrayListOf(LastFmImage("", ""))))).size, 0)
        assertEquals(artistMapper.transform(arrayListOf(null, LastFmArtist("", "fake", arrayListOf(LastFmImage("", ""))))).size, 1)
    }
}