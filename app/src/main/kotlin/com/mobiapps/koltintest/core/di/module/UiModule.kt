package com.mobiapps.koltintest.core.di.module

import com.mobiapps.koltintest.home.HomeUi
import dagger.Module
import dagger.Provides

@Module
class UiModule {

    @Provides
    fun provideHomeUi() = HomeUi()
}