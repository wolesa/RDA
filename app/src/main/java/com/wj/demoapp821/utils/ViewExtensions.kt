package com.wj.demoapp821.utils

import android.view.View
import androidx.annotation.IdRes

fun <T : View> View.bindView(@IdRes viewId: Int): Lazy<T> = lazy(LazyThreadSafetyMode.NONE) {
    findViewById<T>(viewId)
}