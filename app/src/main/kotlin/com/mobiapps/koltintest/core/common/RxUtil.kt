package com.mobiapps.koltintest.core.common

import android.support.v7.widget.SearchView
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.BehaviorSubject

class RxUtil {
    companion object {
        fun dispose(disposable: Disposable?) = disposable?.let {
            if (!disposable.isDisposed) {
                disposable.dispose()
            }
        }

        fun bindToSearchView(searchView: SearchView): Observable<String> {
            val subject: BehaviorSubject<String> = BehaviorSubject.create()
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextChange(newText: String): Boolean {
                    subject.onNext(newText)
                    return true
                }

                override fun onQueryTextSubmit(query: String?): Boolean {
                    subject.onComplete()
                    return true
                }
            })
            return subject
        }
    }
}