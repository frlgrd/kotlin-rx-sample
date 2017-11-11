package com.mobiapps.koltintest.core.di.module

import com.mobiapps.koltintest.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: App) {
    @Provides @Singleton
    fun provideApplication() = app
}