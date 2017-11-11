package com.mobiapps.koltintest.home

import android.content.Context
import android.view.View
import com.mobiapps.koltintest.R
import com.mobiapps.koltintest.common.ui.BaseAdapter
import com.mobiapps.koltintest.core.model.Artist
import org.jetbrains.anko.AnkoContext

class HomeAdapter(context: Context) : BaseAdapter<Artist, HomeAdapter.Holder>(context) {
    override fun getHolder(ui: AnkoContext<Context>) = Holder(with(ui) { artistView() })

    class Holder(itemView: View) : BaseAdapter.BaseViewHolder<Artist>(itemView) {
        private val artistView: ArtistView = itemView.findViewById(R.id.artistView)
        override fun view(item: Artist) {
            artistView.setArtist(item)
        }
    }
}