package com.mobiapps.koltintest.home

import android.os.Bundle
import android.support.v7.widget.SearchView
import android.view.Menu
import com.mobiapps.koltintest.App
import com.mobiapps.koltintest.R
import com.mobiapps.koltintest.core.common.BaseActivity
import com.mobiapps.koltintest.core.common.RxUtil
import org.jetbrains.anko.setContentView
import javax.inject.Inject

class HomeActivity : BaseActivity<HomePresenter>() {

    @Inject lateinit var ui: HomeUi

    init {
        App.deps.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui.setContentView(this)
    }

    override fun buildPresenter(): HomePresenter = HomePresenter(ui)

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        presenter.attachToSearch(RxUtil.bindToSearchView(menu.findItem(R.id.action_search).actionView as SearchView))
        return true
    }
}
