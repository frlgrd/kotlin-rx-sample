package com.mobiapps.koltintest.common.ui.view

interface CollectionView<in T> : LoadableView {

    fun onCollectionLoaded(items: List<T>)
}