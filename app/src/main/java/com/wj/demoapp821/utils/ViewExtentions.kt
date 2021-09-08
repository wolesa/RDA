package com.wj.demoapp821.utils

import android.view.View
import android.widget.TextView

fun TextView.setTextAndUpdateVisibility(text: String?){
    if(text.isNullOrEmpty()) {
        visibility = View.GONE
    } else {
        visibility = View.VISIBLE
        this.text = text
    }
}