package com.andreykosarygin.companies_ui.screen_companies

import androidx.activity.compose.BackHandler
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.andreykosarygin.common.R
import com.andreykosarygin.common.Routes
import com.andreykosarygin.common.ui.theme.buttonRatesNowColorText
import com.andreykosarygin.common.ui.theme.colorWhite

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ApostasEsportivasTheme {
//        ScreenCompanies()
//    }
//}

@Composable
fun ScreenCompanies(
    navController: NavController,
    viewModel: ScreenCompaniesViewModel
) {
    val model by viewModel.model.collectAsState()

    model.navigationEvent?.use { route ->
        when (route) {
            ScreenCompaniesViewModel.Model.NavigationSingleLifeEvent.NavigationDestination.ScreenSignUp ->
                navController.navigate(Routes.SCREEN_SIGN_UP)
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row {
            Company(
                bonusSizeText = stringResource(id = R.string.bonus_500),
                buttonOnClick = { /*TODO*/ },
                companyBackgroundResId = com.andreykosarygin.companies_ui.R.drawable.icon_company_betano
            )

            Company(
                bonusSizeText = stringResource(id = R.string.bonus_200),
                buttonOnClick = { /*TODO*/ },
                companyBackgroundResId = com.andreykosarygin.companies_ui.R.drawable.icon_company_kto
            )
        }
        Row {
            Company(
                bonusSizeText = stringResource(id = R.string.bonus_300),
                buttonOnClick = { /*TODO*/ },
                companyBackgroundResId = com.andreykosarygin.companies_ui.R.drawable.icon_company_pixbet
            )

            Company(
                bonusSizeText = stringResource(id = R.string.bonus_300),
                buttonOnClick = { /*TODO*/ },
                companyBackgroundResId = com.andreykosarygin.companies_ui.R.drawable.icon_company_galerabet
            )
        }
        Row {
            Company(
                bonusSizeText = stringResource(id = R.string.bonus_250_durante),
                buttonOnClick = { /*TODO*/ },
                companyBackgroundResId = com.andreykosarygin.companies_ui.R.drawable.icon_company_bet365
            )

            Company(
                bonusSizeText = stringResource(id = R.string.bonus_200),
                buttonOnClick = { /*TODO*/ },
                companyBackgroundResId = com.andreykosarygin.companies_ui.R.drawable.icon_company_betfair
            )
        }
        Row {
            Company(
                bonusSizeText = stringResource(id = R.string.bonus_multipliers_30),
                buttonOnClick = { /*TODO*/ },
                companyBackgroundResId = com.andreykosarygin.companies_ui.R.drawable.icon_company_blaze
            )

            Company(
                bonusSizeText = stringResource(id = R.string.bonus_multipliers_20),
                buttonOnClick = { /*TODO*/ },
                companyBackgroundResId = com.andreykosarygin.companies_ui.R.drawable.icon_company_sportingbet
            )
        }

        BackHandler {
            viewModel.onBackPressed()
        }
    }
}

@Composable
fun Company(
    bonusSizeText: String,
    buttonOnClick: () -> Unit,
    @DrawableRes companyBackgroundResId: Int,
) {
    Box(
        modifier = Modifier.size(width = 186.dp, height = 169.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Image(
            modifier = Modifier.size(width = 186.dp, height = 169.dp),
            painter = painterResource(
                id = companyBackgroundResId
            ), contentDescription = stringResource(
                id = R.string.content_description_background_company
            )
        )

        Column(
            modifier = Modifier.padding(bottom = 17.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.new_bonus),
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 22.24.sp,
                    fontWeight = FontWeight(300),
                    color = colorWhite,
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier.offset(y = 5.dp)
            )

            Text(
                text = bonusSizeText,
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 22.24.sp,
                    fontWeight = FontWeight(700),
                    color = colorWhite,
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier.padding(bottom = 6.dp)
            )

            ButtonRatesNow(
                onClick = buttonOnClick
            )
        }
    }
}

@Composable
fun ButtonRatesNow(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.size(width = 167.dp, height = 35.dp),
            painter = painterResource(
                id = com.andreykosarygin.companies_ui.R.drawable.button
            ),
            contentDescription = stringResource(
                id = R.string.content_description_background_company
            )
        )
        Row(
            modifier = Modifier
                .clickable(onClick = onClick)
                .offset(x = 5.dp, y = (-2.5).dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center
        ) {
            BasicText(
                text = stringResource(id = R.string.rates_now),
                style = MaterialTheme.typography.labelLarge.copy(
                    color = buttonRatesNowColorText,
                    fontSize = 13.58.sp,
                    lineHeight = 0.sp,
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )
            Image(
                painter = painterResource(id = com.andreykosarygin.companies_ui.R.drawable.icon_arrow_up),
                contentDescription = stringResource(
                    id = R.string.content_description_background_company
                )
            )
        }
    }
}