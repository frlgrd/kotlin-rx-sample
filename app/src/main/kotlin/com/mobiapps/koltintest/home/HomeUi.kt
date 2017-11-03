package com.mobiapps.koltintest.home

import android.content.Context
import android.content.res.ColorStateList
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.mobiapps.koltintest.R
import com.mobiapps.koltintest.core.common.CollectionView
import com.mobiapps.koltintest.core.common.ui.SpaceDecoration
import com.mobiapps.koltintest.core.model.Artist
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.recyclerview.v7.recyclerView

class HomeUi : AnkoComponent<HomeActivity>, CollectionView<Artist> {
    private lateinit var progressBar: View
    private lateinit var noData: View
    private lateinit var homeAdapter: HomeAdapter
    private lateinit var context: Context

    override fun createView(ui: AnkoContext<HomeActivity>) = with(ui) {
        context = ui.ctx
        relativeLayout {
            appBarLayout {
                id = R.id.appBarLayout
                toolbar {
                    title = ui.ctx.getString(R.string.app_name)
                }.let {
                    ui.owner.setSupportActionBar(it)
                }
            }.lparams(width = matchParent, height = wrapContent)

            recyclerView {
                layoutManager = LinearLayoutManager(context)
                homeAdapter = HomeAdapter(context)
                adapter = homeAdapter
            }.lparams(width = matchParent, height = matchParent) {
                below(R.id.appBarLayout)
            }.addItemDecoration(SpaceDecoration(dip(3)))

            verticalLayout {
                progressBar = progressBar {
                    visibility = View.GONE
                    indeterminateTintList = ColorStateList.valueOf(ResourcesCompat.getColor(context.resources, R.color.colorPrimary, null))
                }
                noData = textView(R.string.no_data) {
                    visibility = View.GONE
                }
            }.lparams {
                centerInParent()
            }
        }
    }

    override fun onCollectionLoaded(items: List<Artist>) {
        homeAdapter.items = items
        noData.visibility = if (items.isEmpty()) View.VISIBLE else View.GONE
        (context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
    }

    override fun loadingStateChanged(isLoading: Boolean) {
        if (isLoading) {
            noData.visibility = View.GONE
        }
        progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    override fun onError(error: Throwable) {
        Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
    }
}