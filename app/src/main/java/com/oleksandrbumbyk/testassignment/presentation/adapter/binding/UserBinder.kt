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
import com.oleksandrbumbyk.testassignment.presentation.util.formatDate

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

    fun bindLocation(context: Context, tv: TextView, user: User) {
        val city = user.location?.city ?: ""
        val state = user.location?.state ?: ""
        val location = when {
            city.isNotEmpty() && state.isNotEmpty() -> "$city, $state"
            city.isNotEmpty() -> city
            else -> state
        }
        tv.text = if (location.isNotEmpty()) context.getString(R.string.format_location, location) else ""
    }

    fun bindPhone(context: Context, tv: TextView, user: User) {
        val phone = user.phone ?: ""
        tv.text = if (phone.isNotEmpty()) context.getString(R.string.format_phone, phone) else ""
    }

    fun bindAge(context: Context, tv: TextView, user: User) {
        val age = user.dob?.age
        tv.text = if (age != null) context.getString(R.string.format_age, age) else ""
    }

    fun bindGender(context: Context, tv: TextView, user: User) {
        val gender = user.gender ?: ""
        tv.text = if (gender.isNotEmpty()) context.getString(R.string.format_gender, gender) else ""
    }

    fun bindBirthday(context: Context, tv: TextView, user: User) {
        val birthday = user.dob?.date?.formatDate() ?: ""
        tv.text = if (birthday.isNotEmpty()) context.getString(R.string.format_birthday, birthday) else ""
    }
}
