package com.andreykosarygin.common

import android.graphics.drawable.Drawable

data class CountryCodeInfo(
    val flagIcon: Drawable?,
    val code: Int,
    val name: String,
    val mask: String,
    val phoneNumberLength: Int
)
