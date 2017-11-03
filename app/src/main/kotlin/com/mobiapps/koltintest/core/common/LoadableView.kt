package com.mobiapps.koltintest.core.common

interface LoadableView {

    fun loadingStateChanged(isLoading: Boolean)

    fun onError(error: Throwable)
}