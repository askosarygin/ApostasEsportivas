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
        letterSpacing = 0.5.sp
    ),
    displaySmall = TextStyle(
        fontFamily = FontFamily(Font(resId = R.font.rubik)),
        fontWeight = FontWeight.Bold,
        fontSize = 41.58.sp,
        lineHeight = 49.27.sp
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily(Font(resId = R.font.rubik)),
        fontWeight = FontWeight.Normal,
        fontSize = 22.06.sp,
        lineHeight = 24.38.sp
    ),
    titleSmall = TextStyle(
        fontFamily = FontFamily(Font(resId = R.font.rubik)),
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.44.sp
    ),
    labelLarge = TextStyle(
        fontFamily = FontFamily(Font(resId = R.font.rubik)),
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = 26.07.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily(Font(resId = R.font.rubik)),
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = 26.07.sp
    ),
    bodySmall = TextStyle(
        fontFamily = FontFamily(Font(resId = R.font.rubik)),
        fontWeight = FontWeight.Medium,
        fontSize = 13.58.sp,
        lineHeight = 16.09.sp
    )
)