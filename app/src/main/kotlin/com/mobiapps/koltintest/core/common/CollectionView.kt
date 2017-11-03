package com.mobiapps.koltintest.core.common

interface CollectionView<in T> : LoadableView {

    fun onCollectionLoaded(items: List<T>)
}