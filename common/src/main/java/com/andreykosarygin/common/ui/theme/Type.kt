package com.andreykosarygin.common.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.andreykosarygin.common.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
        color = textColorWhite
    ),
    displaySmall = TextStyle(
        fontFamily = FontFamily(Font(resId = R.font.rubik_bold_700)),
        fontSize = 41.58.sp,
        lineHeight = 49.27.sp,
        color = textColorWhite
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily(Font(resId = R.font.rubik_regular_400)),
        fontSize = 22.06.sp,
        lineHeight = 24.38.sp,
        color = textColorWhite
    ),
    titleSmall = TextStyle(
        fontFamily = FontFamily(Font(resId = R.font.rubik_regular_400)),
        fontSize = 14.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.44.sp,
        color = textColorWhite
    ),
    labelLarge = TextStyle(
        fontFamily = FontFamily(Font(resId = R.font.rubik_bold_700)),
        fontSize = 22.sp,
        lineHeight = 26.07.sp,
        color = textColorWhite
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily(Font(resId = R.font.rubik_medium_500)),
        fontSize = 13.58.sp,
        lineHeight = 16.09.sp,
        color = textColorWhite
    ),
    bodySmall = TextStyle(
        fontFamily = FontFamily(Font(resId = R.font.rubik_regular_400)),
        fontSize = 12.sp,
        lineHeight = 14.22.sp,
        color = textColorWhite
    )
)