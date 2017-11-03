package com.mobiapps.koltintest.home

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.support.v7.widget.CardView
import android.util.Log
import android.view.ViewManager
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.mobiapps.koltintest.R
import com.mobiapps.koltintest.core.model.Artist
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.ankoView

class ArtistView(context: Context) : CardView(context) {

    private lateinit var name: TextView
    private lateinit var image: ImageView

    init {
        AnkoContext.createDelegate(this).apply {
            id = R.id.artistView
            layoutParams = RelativeLayout.LayoutParams(matchParent, dip(150))
            relativeLayout {
                image = imageView {
                    backgroundResource = android.R.color.darker_gray
                    scaleType = ImageView.ScaleType.CENTER_CROP
                }.lparams(width = matchParent, height = matchParent)

                name = textView {
                    padding = dip(20)
                    textColor = Color.WHITE
                    backgroundResource = R.drawable.dark_gradient
                    textSize = 25F
                    typeface = Typeface.DEFAULT_BOLD
                }.lparams(width = matchParent) {
                    alignParentBottom()
                }
            }
        }
    }

    fun setArtist(artist: Artist) {
        name.text = artist.name
        if ((artist.url ?: "").isNotBlank()) {
            Picasso.with(context)
                    .load(artist.url)
                    .into(image)
        } else {
            Log.e("URL EMPTY", "$artist")
        }
    }
}

@Suppress("NOTHING_TO_INLINE")
inline fun ViewManager.artistView(theme: Int = 0) = artistView({}, theme)

inline fun ViewManager.artistView(init: ArtistView.() -> Unit, theme: Int = 0) = ankoView(::ArtistView, theme, init)