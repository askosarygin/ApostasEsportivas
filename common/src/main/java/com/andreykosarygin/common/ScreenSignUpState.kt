package com.andreykosarygin.common

import android.graphics.drawable.Drawable
import java.io.Serializable

data class ScreenSignUpState(
    val buttonRegistrationEnabled: Boolean,
    val phoneNumber: String,
    val phoneNumberLength: Int,
    val countryFlag: Drawable?,
    val phoneCode: String,
    val phoneMask: String,
) : Serializable