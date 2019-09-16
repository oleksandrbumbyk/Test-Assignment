package com.oleksandrbumbyk.testassignment.presentation.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import timber.log.Timber
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun <T> lazyThreadSafetyNone(initializer: () -> T): Lazy<T> = lazy(LazyThreadSafetyMode.NONE, initializer)

fun String.formatDate(): String {
    var formattedDate = ""
    try {
        SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault()).parse(this)?.let {
            formattedDate = SimpleDateFormat("yyyy-mm-dd", Locale.getDefault()).format(it)
        }
    } catch (e: ParseException) {
        Timber.d(e)
    }
    return formattedDate
}

fun startCallActivity(context: Context, number: String) {
    if (number.isEmpty()) return
    context.startActivity(Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", number, null)))
}
