package com.mobiapps.koltintest.core.deps

import com.mobiapps.koltintest.BuildConfig
import com.mobiapps.koltintest.core.network.LastFmRequestInterceptor
import com.mobiapps.koltintest.core.network.RestService
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.File
import javax.inject.Singleton

@Module
class NetworkModule(private val cacheFile: File) {
    @Provides @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.BASEURL)
                .client(OkHttpClient.Builder()
                        .addInterceptor(LastFmRequestInterceptor(BuildConfig.API_KEY))
                        .cache(Cache(cacheFile, 10 * 10 * 1024))
                        .build())
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @Provides @Singleton
    fun provideRestService(retrofit: Retrofit): RestService = retrofit.create(RestService::class.java)
}