package com.andreykosarygin.signup_ui.screen_signup.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class PhoneNumberVisualTransformation(
    private val phoneNumberLength: Int,
    private val mask: String,
    private val whatCharInMaskIsPhoneNumber: Char
) : VisualTransformation {

    override fun filter(text: AnnotatedString): TransformedText {
        val phoneNumber = if (text.text.length > phoneNumberLength) {
            text.text.substring(0 until phoneNumberLength)
        } else {
            text.text
        }
        val annotatedString = buildAnnotatedString {
            if (phoneNumber.isEmpty()) {
                pushStyle(SpanStyle(color = Color.LightGray))
            }

            var phoneNumberIndex = 0

            mask.forEach {
                if (it != whatCharInMaskIsPhoneNumber) {
                    append(it)
                } else {
                    if (phoneNumber.isNotEmpty()) {

                        if (phoneNumberIndex > phoneNumber.lastIndex) {
                            append(it)
                        }
                        if (phoneNumberIndex == phoneNumber.lastIndex) {
                            append(phoneNumber[phoneNumberIndex])
                            phoneNumberIndex++
                            pushStyle(SpanStyle(color = Color.LightGray))
                        }
                        if (phoneNumberIndex < phoneNumber.lastIndex) {
                            append(phoneNumber[phoneNumberIndex])
                            phoneNumberIndex++
                        }

                    } else {
                        append(it)
                    }
                }
            }
        }

        return TransformedText(annotatedString, PhoneNumberOffsetMapping())
    }

    private class PhoneNumberOffsetMapping : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            return 0
        }

        override fun transformedToOriginal(offset: Int): Int {
            return 0
        }
    }
}