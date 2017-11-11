package com.mobiapps.koltintest.core.di.module

import com.mobiapps.koltintest.core.model.mapper.ArtistMapper
import com.mobiapps.koltintest.core.model.mapper.ImageMapper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MapperModule {
    @Provides
    @Singleton
    fun provideImageMapper() = ImageMapper()

    @Provides
    @Singleton
    fun provideArtistMapper() = ArtistMapper()
}