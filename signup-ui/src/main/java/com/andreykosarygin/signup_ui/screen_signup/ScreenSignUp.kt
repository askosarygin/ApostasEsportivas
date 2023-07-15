package com.andreykosarygin.signup_ui.screen_signup

import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import com.andreykosarygin.common.CountryCodeInfo
import com.andreykosarygin.common.R
import com.andreykosarygin.common.Routes
import com.andreykosarygin.common.ui.theme.appNameBackground
import com.andreykosarygin.common.ui.theme.buttonColorText
import com.andreykosarygin.common.ui.theme.colorWhite
import com.andreykosarygin.signup_ui.screen_signup.utils.PhoneNumberVisualTransformation
import com.google.accompanist.drawablepainter.rememberDrawablePainter

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
//    ApostasEsportivasTheme {
//        ScreenSignUp(ScreenSignUpViewModel())
//    }
}

@Composable
fun ScreenSignUp(
    navController: NavController,
    viewModel: ScreenSignUpViewModel
) {
    val model by viewModel.model.collectAsState()

    model.navigationEvent?.use { route ->
        when (route) {
            ScreenSignUpViewModel.Model.NavigationSingleLifeEvent.NavigationDestination.ScreenTerms ->
                navController.navigate(Routes.SCREEN_TERMS)

            ScreenSignUpViewModel.Model.NavigationSingleLifeEvent.NavigationDestination.ScreenCompanies ->
                navController.navigate(Routes.SCREEN_COMPANIES)
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        HeaderAppName()
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Text(
            modifier = Modifier.padding(bottom = 30.dp),
            text = stringResource(id = R.string.notice_about_private_policy),
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center
        )
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (
                welcome,
                registerToChooseBookmaker,
                enterPhoneNumber,
                phoneEntryField,
                registrationButton,
                confirm,
                termsOfUse,
                countriesCodeList
            ) = createRefs()

            Text(
                text = stringResource(id = R.string.welcome),
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.constrainAs(welcome) {
                    top.linkTo(anchor = parent.top, margin = 214.dp)
                    start.linkTo(anchor = parent.start)
                    end.linkTo(anchor = parent.end)
                }
            )

            Text(
                text = stringResource(id = R.string.register_to_choose_a_bookmaker),
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.constrainAs(registerToChooseBookmaker) {
                    top.linkTo(anchor = welcome.bottom, margin = 5.dp)
                    start.linkTo(anchor = parent.start)
                    end.linkTo(anchor = parent.end)
                }
            )

            Text(
                text = stringResource(id = R.string.enter_number_of_phone),
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.constrainAs(enterPhoneNumber) {
                    start.linkTo(anchor = phoneEntryField.start)
                    bottom.linkTo(anchor = phoneEntryField.top, margin = 5.dp)
                }
            )

            PhoneEntryField(
                countryFlag = model.countryFlag,
                phoneCode = model.phoneCode,
                phoneNumber = model.phoneNumber,
                phoneNumberLength = model.phoneNumberLength,
                phoneMask = model.phoneMask,
                whatCharInMaskIsPhoneNumber = model.whatCharInMaskIsPhoneNumber,
                onPhoneChange = {
                    viewModel.phoneNumberChanged(newPhoneNumber = it)
                },
                modifier = Modifier.constrainAs(phoneEntryField) {
                    bottom.linkTo(anchor = registrationButton.top, margin = 32.dp)
                    start.linkTo(anchor = registrationButton.start)
                    end.linkTo(anchor = registrationButton.end)
                    width = Dimension.fillToConstraints
                },
                onCountryCodeSelectorClick = {
                    viewModel.countryCodeSelectionPressed()
                }
            )

            RegistrationButton(
                enabled = model.buttonRegistrationEnabled,
                modifier = Modifier.constrainAs(registrationButton) {
                    top.linkTo(anchor = welcome.bottom, margin = 198.dp)
                    start.linkTo(anchor = parent.start)
                    end.linkTo(anchor = parent.end)
                },
                onClick = {
                    //todo
                }
            )

            Text(
                text = stringResource(id = R.string.confirm),
                style = MaterialTheme.typography.bodySmall.copy(
                    fontSize = 11.sp,
                    lineHeight = 13.04.sp
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.constrainAs(confirm) {
                    top.linkTo(anchor = registrationButton.bottom, margin = 14.dp)
                    start.linkTo(anchor = parent.start)
                    end.linkTo(anchor = parent.end)
                }
            )

            Text(
                text = stringResource(id = R.string.terms_of_use_and_privacy_policy),
                style = MaterialTheme.typography.labelSmall,
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier
                    .constrainAs(termsOfUse) {
                        top.linkTo(anchor = confirm.bottom, margin = 14.dp)
                        start.linkTo(anchor = parent.start)
                        end.linkTo(anchor = parent.end)
                    }
                    .clickable {
                        viewModel.termsOfUseAndPrivacyPolicyClicked()
                    }
            )

            if (model.showCodesOfCountriesList) {
                CountriesCodeList(
                    modifier = Modifier
                        .constrainAs(countriesCodeList) {
                            top.linkTo(anchor = phoneEntryField.bottom, margin = 5.dp)
                            start.linkTo(anchor = phoneEntryField.start)
                            end.linkTo(anchor = phoneEntryField.end)
                            bottom.linkTo(anchor = parent.bottom)
                            width = Dimension.fillToConstraints
                            height = Dimension.fillToConstraints
                        },
                    listOfCountries = model.countriesCodeList,
                    onCodeCountryClick = {
                        viewModel.countryCodeSelected(it)
                    }
                )
            }
        }
    }
}

@Composable
fun RegistrationButton(
    enabled: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Button(
            enabled = enabled,
            onClick = onClick,
            shape = RoundedCornerShape(size = 2.93333.dp),
            colors = ButtonDefaults.buttonColors(
                disabledContainerColor = colorWhite
            ),
            contentPadding = PaddingValues(
                start = 50.dp,
                top = 7.5.dp,
                end = 50.dp,
                bottom = 6.dp
            )
        ) {
            Text(
                text = stringResource(id = R.string.registration),
                style = MaterialTheme.typography.labelLarge.copy(
                    color = buttonColorText
                )
            )
        }
    }
}

@Composable
private fun PhoneEntryField(
    countryFlag: Drawable?,
    phoneCode: String,
    phoneNumber: String,
    phoneNumberLength: Int,
    phoneMask: String,
    whatCharInMaskIsPhoneNumber: Char,
    onPhoneChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    onCountryCodeSelectorClick: () -> Unit
) {
    Box(modifier = modifier) {
        BasicTextField(
            value = phoneNumber,
            onValueChange = onPhoneChange,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            singleLine = true,
            modifier = Modifier
                .background(color = colorWhite, shape = RoundedCornerShape(size = 3.dp))
                .fillMaxWidth()
                .padding(top = 7.dp, bottom = 10.dp),
            visualTransformation = PhoneNumberVisualTransformation(
                phoneNumberLength = phoneNumberLength,
                mask = phoneMask,
                whatCharInMaskIsPhoneNumber = whatCharInMaskIsPhoneNumber
            ),
            cursorBrush = SolidColor(Color.Transparent),
            textStyle = TextStyle(
                letterSpacing = 0.44.sp,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                textAlign = TextAlign.Center
            ),
            decorationBox = { innerTextField ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    var weightPhoneNumberBox by remember {
                        mutableFloatStateOf(0.1f)
                    }

                    if (phoneCode != "Select country code") {
                        weightPhoneNumberBox = 5f
                    }

                    Box(
                        modifier = Modifier
                            .clickable(onClick = onCountryCodeSelectorClick)
                            .weight(3f)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            if (countryFlag != null) {
                                Image(
                                    modifier = Modifier.padding(start = 20.dp),
                                    painter = rememberDrawablePainter(drawable = countryFlag),
                                    contentDescription = stringResource(id = R.string.content_description_icon_flag)
                                )
                            }
                            BasicText(
                                modifier = Modifier.padding(
                                    top = 1.dp,
                                    bottom = 1.dp,
                                    start = 5.dp,
                                    end = 5.dp
                                ),
                                text = phoneCode,
                                maxLines = 1,
                                style = TextStyle(
                                    letterSpacing = 0.44.sp,
                                    fontSize = 16.sp,
                                    lineHeight = 24.sp,
                                    textAlign = TextAlign.Center
                                )
                            )
                        }
                    }

                    Box(modifier = Modifier.weight(weightPhoneNumberBox)) {
                        val textSelectionColors by remember {
                            mutableStateOf(
                                TextSelectionColors(
                                    handleColor = Color.Transparent,
                                    backgroundColor = Color.Transparent
                                )
                            )
                        }
                        CompositionLocalProvider(LocalTextSelectionColors provides textSelectionColors) {
                            innerTextField()
                        }
                    }
                }
            }
        )
    }
}

@Composable
private fun CountriesCodeList(
    modifier: Modifier = Modifier,
    listOfCountries: List<CountryCodeInfo>,
    onCodeCountryClick: (selectedCodeCountryIndex: Int) -> Unit
) {
    Box(modifier = modifier) {
        LazyColumn {
            itemsIndexed(items = listOfCountries) { index, country ->
                Row(
                    modifier = Modifier
                        .background(color = colorWhite)
                        .padding(vertical = 5.dp)
                        .clickable(onClick = { onCodeCountryClick(index) }),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier.weight(1.5f),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Image(
                            modifier = Modifier.padding(start = 20.dp),
                            painter = rememberDrawablePainter(drawable = country.flagIcon),
                            contentDescription = stringResource(id = R.string.content_description_icon_flag)
                        )
                    }
                    Box(
                        modifier = Modifier.weight(1.5f),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        BasicText(
                            modifier = Modifier.padding(end = 5.dp),
                            text = "+${country.code}",
                            style = TextStyle(
                                letterSpacing = 0.44.sp,
                                fontSize = 16.sp,
                                lineHeight = 24.sp,
                                textAlign = TextAlign.Center
                            )
                        )
                    }
                    Box(
                        modifier = Modifier.weight(5f),
                        contentAlignment = Alignment.Center
                    ) {
                        BasicText(
                            text = country.name,
                            style = TextStyle(
                                letterSpacing = 0.44.sp,
                                fontSize = 16.sp,
                                lineHeight = 24.sp,
                                textAlign = TextAlign.Center
                            )
                        )
                    }
                }
            }
        }
    }
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