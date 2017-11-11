package com.mobiapps.koltintest.common.ui

import android.support.v7.app.AppCompatActivity
import com.mobiapps.koltintest.common.Presenter

abstract class BaseActivity<PRESENTER : Presenter> : AppCompatActivity() {

    protected lateinit var presenter: PRESENTER

    override fun onResume() {
        super.onResume()
        presenter = buildPresenter()
    }

    abstract fun buildPresenter(): PRESENTER

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}