package com.mobiapps.koltintest.common.ui.view

interface LoadableView {

    fun loadingStateChanged(isLoading: Boolean)

    fun onError(error: Throwable)
}