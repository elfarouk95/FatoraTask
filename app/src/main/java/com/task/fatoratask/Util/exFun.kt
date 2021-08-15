package com.task.fatoratask.Util

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.Load(link: String) {
    Glide.with(this.context).load("https://image.tmdb.org/t/p/w500" + link).into(this)
}