package com.andreykosarygin.signup_ui.screen_signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.andreykosarygin.common.R
import com.andreykosarygin.common.ui.theme.ApostasEsportivasTheme
import com.andreykosarygin.common.ui.theme.appNameBackground
import com.andreykosarygin.common.ui.theme.buttonColorText
import com.andreykosarygin.common.ui.theme.colorWhite
import com.andreykosarygin.common.utils.phonenumberutil.PhoneNumberUtil
import com.andreykosarygin.signup_ui.screen_signup.utils.PhoneNumberVisualTransformation

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ApostasEsportivasTheme {
        ScreenSignUp(ScreenSignUpViewModel())
    }
}

@Composable
fun ScreenSignUp(
    viewModel: ScreenSignUpViewModel
) {
    val model by viewModel.model.collectAsState()

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
            text = stringResource(id = R.string.notice_about_private_policy),
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center
        )
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ConstraintLayout {
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
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(registerToChooseBookmaker.top)
                }
            )

            Text(
                text = stringResource(id = R.string.register_to_choose_a_bookmaker),
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.constrainAs(registerToChooseBookmaker) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(enterPhoneNumber.top)
                }
            )

            Text(
                text = stringResource(id = R.string.enter_number_of_phone),
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.constrainAs(enterPhoneNumber) {
                    start.linkTo(phoneEntryField.start)
                    bottom.linkTo(phoneEntryField.top)
                }
            )

            PhoneEntryField(
                phoneCode = model.phoneCode,
                phoneNumber = model.phoneNumber,
                phoneMask = model.phoneMask,
                whatCharInMaskIsPhoneNumber = model.whatCharInMaskIsPhoneNumber,
                onPhoneChange = {
                    viewModel.phoneNumberChanged(newPhoneNumber = it)
                },
                modifier = Modifier.constrainAs(phoneEntryField) {
                    start.linkTo(registrationButton.start)
                    end.linkTo(registrationButton.end)
                    width = Dimension.fillToConstraints
                },
                onCountryCodeSelectorClick = {
                    viewModel.countryCodeSelectionPressed()
                }
            )

            RegistrationButton(
                modifier = Modifier.constrainAs(registrationButton) {
                    top.linkTo(phoneEntryField.bottom, margin = 32.dp)
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
                    top.linkTo(registrationButton.bottom)
                    start.linkTo(registrationButton.start)
                    end.linkTo(registrationButton.end)
                }
            )

            Text(
                text = stringResource(id = R.string.terms_of_use_and_privacy_policy),
                style = MaterialTheme.typography.labelSmall,
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.constrainAs(termsOfUse) {
                    top.linkTo(confirm.bottom)
                    start.linkTo(confirm.start)
                    end.linkTo(confirm.end)
                }
            )
            if (model.showCodesOfCountriesList) {
                CountriesCodeList(
                    modifier = Modifier.constrainAs(countriesCodeList) {
                        top.linkTo(phoneEntryField.bottom, margin = 5.dp)
                        start.linkTo(phoneEntryField.start)
                        end.linkTo(phoneEntryField.end)
                        width = Dimension.fillToConstraints
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
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(size = 2.93333.dp),
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

@Composable
private fun PhoneEntryField(
    phoneCode: String,
    phoneNumber: String,
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
                mask = phoneMask,
                whatCharInMaskIsPhoneNumber = whatCharInMaskIsPhoneNumber
            ),
            decorationBox = { innerTextField ->
                Row {
                    Box(
                        modifier = Modifier.weight(3f),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        BasicText(
                            modifier = Modifier
                                .padding(end = 5.dp)
                                .clickable(onClick = onCountryCodeSelectorClick),
                            text = phoneCode,
                            maxLines = 1
                        )
                    }

                    Box(modifier = Modifier.weight(5f)) {
                        innerTextField()
                    }
                }
            }
        )
    }
}

@Composable
private fun CountriesCodeList(
    modifier: Modifier = Modifier,
    listOfCountries: List<PhoneNumberUtil.Country>,
    onCodeCountryClick: (selectedCodeCountryIndex: Int) -> Unit
) {
    Box(modifier = modifier) {
        LazyColumn {
            itemsIndexed(items = listOfCountries) { index, country ->
                Row(
                    modifier = Modifier
                        .background(color = colorWhite)
                        .padding(vertical = 5.dp)
                        .clickable(onClick = { onCodeCountryClick(index) })
                ) {
                    Box(
                        modifier = Modifier.weight(3f),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        BasicText(
                            modifier = Modifier.padding(end = 5.dp),
                            text = "+${country.code}"
                        )
                    }
                    Box(
                        modifier = Modifier.weight(5f),
                        contentAlignment = Alignment.Center
                    ) {
                        BasicText(text = country.name)
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