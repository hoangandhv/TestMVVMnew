package com.gvtechcom.testfirebase.utis

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.databinding.BindingAdapter

@BindingAdapter ("showtoat")
fun showtoat(view: View, message: String?) {
    Toast.makeText(view.context, message, Toast.LENGTH_LONG).show()
}

