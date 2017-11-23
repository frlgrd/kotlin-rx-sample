package com.mobiapps.koltintest.home

import android.content.Context
import android.view.inputmethod.InputMethodManager
import com.mobiapps.koltintest.App
import com.mobiapps.koltintest.common.Presenter
import com.mobiapps.koltintest.common.RxUtil
import com.mobiapps.koltintest.common.ui.view.CollectionView
import com.mobiapps.koltintest.core.model.artist.Artist
import com.mobiapps.koltintest.core.model.artist.mapper.ArtistMapper
import com.mobiapps.koltintest.core.network.RestService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class HomePresenter(private val context: Context, private val view: CollectionView<Artist>) : Presenter {

    private lateinit var job: Disposable

    @Inject lateinit var restService: RestService
    @Inject lateinit var artistMapper: ArtistMapper

    init {
        App.deps.inject(this)
    }

    fun attachToSearch(stringObservable: Observable<String>) {
        job = stringObservable
                .debounce(500, TimeUnit.MILLISECONDS)
                .filter({ it.length > 1 })
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext({ view.loadingStateChanged(true) })
                .flatMap({
                    restService.searchArtist(it)
                            .map { response -> artistMapper.transform(response.results?.foundedArtist?.artists) }
                            .subscribeOn(Schedulers.io())
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.loadingStateChanged(false)
                    view.onCollectionLoaded(it)
                    (context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
                }, { view.onError(it) })
    }

    override fun onDestroy() {
        RxUtil.dispose(job)
    }
}