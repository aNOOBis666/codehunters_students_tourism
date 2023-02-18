package com.codehunters.studtour.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.codehunters.studtour.R
import com.google.android.material.snackbar.Snackbar

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

fun ImageView.loadImage(imageUrl: String?, options: RequestOptions? = null) {
    Glide.with(this)
        .load(imageUrl).apply {
            options?.let {
                apply(options)
            }
        }
        .into(this)
}

fun View.showSnackbar(message: String) {
    val snackbar = Snackbar.make(this, message, Snackbar.LENGTH_LONG)
    snackbar.setActionTextColor(
        ContextCompat.getColor(this.context, R.color.background_primary)
    )
    snackbar.view.background = ResourcesCompat.getDrawable(this.resources, R.drawable.drw_error, null)
    snackbar.show()
}

fun View.visible(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE
    else View.GONE
}