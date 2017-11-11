package com.mobiapps.koltintest.core.di.component

import com.mobiapps.koltintest.core.di.module.MapperModule
import com.mobiapps.koltintest.core.di.module.NetworkModule
import com.mobiapps.koltintest.core.di.module.UiModule
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