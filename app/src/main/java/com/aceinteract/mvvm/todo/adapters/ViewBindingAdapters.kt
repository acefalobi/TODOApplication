package com.aceinteract.mvvm.todo.adapters

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("app:isGone")
fun bindIsGone(view: View, isGone: Boolean?) {
    view.visibility = if (isGone == true) {
        View.GONE
    } else {
        View.VISIBLE
    }
}
