package com.mobiapps.koltintest.core.common

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.AnkoContext
import kotlin.properties.Delegates

abstract class BaseAdapter<ITEM, HOLDER : BaseAdapter.BaseViewHolder<ITEM>>(private val context: Context) : RecyclerView.Adapter<HOLDER>() {
    var items: List<ITEM> by Delegates.observable(emptyList()) { _, _, _ ->
        run {
            // Update ui when data set changed
            notifyDataSetChanged()
        }
    }

    override fun getItemCount() = items.size
    override fun onBindViewHolder(holder: HOLDER, position: Int) = holder.view(items[position])
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HOLDER = getHolder(AnkoContext.Companion.createReusable(context))

    protected abstract fun getHolder(ui: AnkoContext<Context>): HOLDER

    abstract class BaseViewHolder<in ITEM>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun view(item: ITEM)
    }
}