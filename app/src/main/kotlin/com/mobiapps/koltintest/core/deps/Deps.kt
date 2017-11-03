package com.mobiapps.koltintest.core.deps

import com.mobiapps.koltintest.core.model.mapper.ArtistMapper
import com.mobiapps.koltintest.home.HomeActivity
import com.mobiapps.koltintest.home.HomePresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        NetworkModule::class,
        MapperModule::class,
        UiModule::class
))
interface Deps {
    fun inject(homePresenter: HomePresenter)
    fun inject(artistMapper: ArtistMapper)
    fun inject(homeActivity: HomeActivity)
}