package com.mpp.seed.android.extensions

import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.transition.TransitionManager

fun AppCompatActivity.animate(container: ViewGroup) {
    TransitionManager.beginDelayedTransition(container)
}
