package com.andreykosarygin.signup_ui.screen_terms

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.andreykosarygin.common.R
import com.andreykosarygin.common.Routes

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ApostasEsportivasTheme {
//        ScreenTerms()
//    }
//}

@Composable
fun ScreenTerms(
    navController: NavController,
    viewModel: ScreenTermsViewModel
) {
    val model by viewModel.model.collectAsState()

    model.navigationEvent?.use { route ->
        when (route) {
            ScreenTermsViewModel.Model.NavigationSingleLifeEvent.NavigationDestination.ScreenSignUp ->
                navController.navigate(Routes.SCREEN_SIGN_UP)
        }
    }
    val scroll = rememberScrollState()
    Text(
        modifier = Modifier
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .verticalScroll(state = scroll),
        text = stringResource(id = R.string.terms_of_use_and_privacy_policy_text),
        style = MaterialTheme.typography.labelSmall,
        textAlign = TextAlign.Left,
    )

    BackHandler {
        viewModel.onBackPressed()
    }
}