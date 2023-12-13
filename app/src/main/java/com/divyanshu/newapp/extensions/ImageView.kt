package com.divyanshu.newapp.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(url: String, circleCrop: Boolean = false) {
  if (circleCrop) {Glide.with(this).load(url).circleCrop().into(this)}
  else {Glide.with(this).load(url).into(this)}
}