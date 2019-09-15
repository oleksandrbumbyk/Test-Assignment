package com.oleksandrbumbyk.testassignment.presentation.adapter.binding

import android.annotation.SuppressLint
import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.oleksandrbumbyk.testassignment.R
import com.oleksandrbumbyk.testassignment.domain.entity.User

@SuppressLint("SetTextI18n")
object UserBinder {

    fun bindImage(context: Context, iv: ImageView, user: User) {
        Glide.with(context)
            .load(user.picture?.large ?: "")
            .apply(RequestOptions.circleCropTransform())
            .apply(RequestOptions.placeholderOf(R.drawable.ic_profile_pic))
            .apply(RequestOptions.errorOf(R.drawable.ic_profile_pic))
            .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
            .into(iv)
    }

    fun bindName(tv: TextView, user: User) {
        tv.text = "${user.name?.first ?: ""} ${user.name?.last ?: ""}".trim()
    }

    fun bindEmail(tv: TextView, user: User) {
        tv.text = user.email ?: ""
    }

    fun bindLocation(tv: TextView, user: User) {
        val city = user.location?.city ?: ""
        val state = user.location?.state ?: ""
        tv.text = when {
            city.isNotEmpty() && state.isNotEmpty() -> "$city, $state"
            city.isNotEmpty() -> city
            else -> state
        }
    }

    fun bindPhone(tv: TextView, user: User) {
        tv.text = user.phone ?: ""
    }

    fun bindAge(context: Context, tv: TextView, user: User) {
        val age = user.dob?.age
        tv.text = if (age != null) context.getString(R.string.format_years_old, age) else ""
    }
}
