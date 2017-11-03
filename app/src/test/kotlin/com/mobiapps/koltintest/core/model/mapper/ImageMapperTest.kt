package com.mobiapps.koltintest.core.model.mapper

import com.mobiapps.koltintest.core.model.dto.LastFmImage
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class ImageMapperTest {
    private lateinit var imageMapper: ImageMapper

    @Before
    fun setup() {
        imageMapper = ImageMapper()
    }

    @Test
    fun noData() {
        assertNull(imageMapper.getMainImageUrl(null))
        assertNull(imageMapper.getMainImageUrl(arrayListOf()))
    }

    @Test
    fun filledWithNull() {
        assertNull(imageMapper.getMainImageUrl(arrayListOf(null)))
    }

    @Test
    fun filledWithNullAndNotNull() {
        assertNull(imageMapper.getMainImageUrl(arrayListOf(null, LastFmImage("", ""))))
        assertNotNull(imageMapper.getMainImageUrl(arrayListOf(LastFmImage("fake url", "fake size"))))
        assertEquals(imageMapper.getMainImageUrl(arrayListOf(
                LastFmImage("small url", "small"),
                LastFmImage("extralarge url", "extralarge")
        )), "extralarge url")
        assertEquals(imageMapper.getMainImageUrl(arrayListOf(
                LastFmImage("small url", "small"),
                LastFmImage("last url", "no size but last")
        )), "last url")
    }
}