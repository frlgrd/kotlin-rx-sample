package com.mobiapps.koltintest.core.model.mapper

import com.mobiapps.koltintest.core.model.dto.LastFmImage
import com.mobiapps.koltintest.core.model.dto.LastFmImageType

class ImageMapper {
    fun getMainImageUrl(images: List<LastFmImage?>?): String? {
        if (images == null || images.isEmpty()) {
            return null
        }

        val image = images.firstOrNull { it?.size == LastFmImageType.EXTRALARGE.type }
        val url = image?.url ?: images.last()?.url
        return url?.let { if (url.isNotBlank()) url else null }
    }
}