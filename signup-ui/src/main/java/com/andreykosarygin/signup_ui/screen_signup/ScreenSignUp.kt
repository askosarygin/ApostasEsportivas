package com.andreykosarygin.signup_ui.screen_signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andreykosarygin.common.R
import com.andreykosarygin.common.ui.theme.ApostasEsportivasTheme
import com.andreykosarygin.common.ui.theme.appNameBackground
import com.andreykosarygin.common.ui.theme.buttonColorText

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ApostasEsportivasTheme {
        ScreenSignUp()
    }
}

@Composable
fun ScreenSignUp(
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        HeaderAppName()

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.welcome),
                style = MaterialTheme.typography.displaySmall
            )

            Text(
                text = stringResource(id = R.string.register_to_choose_a_bookmaker),
                style = MaterialTheme.typography.titleLarge
            )

            Text(
                text = stringResource(id = R.string.enter_number_of_phone),
                style = MaterialTheme.typography.titleSmall
            )

//            PhoneEntryField()

            RegistrationButton({})

            Text(
                text = stringResource(id = R.string.confirm),
                style = MaterialTheme.typography.bodySmall.copy(
                    fontSize = 11.sp,
                    lineHeight = 13.04.sp
                ),
                textAlign = TextAlign.Center
            )

            Text(
                text = stringResource(id = R.string.terms_of_use_and_privacy_policy),
                style = MaterialTheme.typography.labelSmall,
                textAlign = TextAlign.Center
            )


        }
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text(
                text = stringResource(id = R.string.notice_about_private_policy),
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun RegistrationButton(
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(size = 2.93333.dp)
    ) {
        Text(
            modifier = Modifier.padding(
                start = 50.dp,
                top = 11.34304.dp,
                end = 50.dp,
                bottom = 12.52362.dp
            ),
            text = stringResource(id = R.string.registration),
            style = MaterialTheme.typography.labelLarge.copy(
                color = buttonColorText
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PhoneEntryField(
    phone: String,
    modifier: Modifier = Modifier,
    mask: String = "000 000 00 00",
    maskNumber: Char = '0',
    onPhoneChanged: (String) -> Unit
) {
//    TextField(
//        value = phone,
//        onValueChange = { it ->
//            onPhoneChanged(it.take(mask.count { it == maskNumber }))
//        },
//        label = {
//            Text(text = "Phone number")
//        },
//        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
//        visualTransformation = PhoneVisualTransformation(mask, maskNumber),
//        modifier = modifier.fillMaxWidth(),
//    )
}

@Composable
private fun HeaderAppName() {
    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier.background(color = appNameBackground)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        vertical = 7.5.dp,
                        horizontal = 80.dp
                    ),
                painter = painterResource(id = com.andreykosarygin.signup_ui.R.drawable.app_name),
                contentDescription = stringResource(
                    id = R.string.content_description_background_app_name
                ),
                contentScale = ContentScale.FillWidth
            )
        }
    }

}

