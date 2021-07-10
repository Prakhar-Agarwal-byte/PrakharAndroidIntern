package com.example.prakharandroidintern.adapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("numOfPeople")
fun TextView.bindIsGone(numOfPeople: Int) {
    this.text = "${numOfPeople} people nearby"
}

@BindingAdapter("imgUrl")
fun ImageView.imgUrl(url: Int) {
    this.setImageDrawable(context.getDrawable(url))
}