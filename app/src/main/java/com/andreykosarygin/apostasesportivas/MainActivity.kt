package com.andreykosarygin.apostasesportivas

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.andreykosarygin.common.Routes
import com.andreykosarygin.common.SavedStateKeys
import com.andreykosarygin.common.ScreenSignUpState
import com.andreykosarygin.common.ui.theme.ApostasEsportivasTheme
import com.andreykosarygin.data.RepositorySignUpDomainImpl
import com.andreykosarygin.data.countriescodes.CountriesCodesStorageImpl
import com.andreykosarygin.signup_domain.InteractorImpl
import com.andreykosarygin.signup_domain.usecases.LoadCountriesCodesUseCase
import com.andreykosarygin.signup_ui.screen_signup.ScreenSignUp
import com.andreykosarygin.signup_ui.screen_signup.ScreenSignUpViewModel

class MainApp : Application() {
    private lateinit var countriesCodesStorageImpl: CountriesCodesStorageImpl
    private lateinit var repositorySignUpDomainImpl: RepositorySignUpDomainImpl
    lateinit var interactorSignUpDomain: InteractorImpl

    override fun onCreate() {
        super.onCreate()

        countriesCodesStorageImpl = CountriesCodesStorageImpl(this)
        repositorySignUpDomainImpl = RepositorySignUpDomainImpl(countriesCodesStorageImpl)
        interactorSignUpDomain = InteractorImpl(
            LoadCountriesCodesUseCase(repositorySignUpDomainImpl)
        )
    }
}

class MainActivity : ComponentActivity() {
    private fun getApplicationInstance() = application as MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApostasEsportivasTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = Routes.SCREEN_SIGN_UP) {
                    composable(route = Routes.SCREEN_SIGN_UP) {
                        val screenState =
                            navController.previousBackStackEntry?.savedStateHandle?.get<ScreenSignUpState>(
                                SavedStateKeys.KEY_STATE_SCREEN_SIGN_UP
                            )

                        ScreenSignUp(
                            screenState = screenState,
                            navController = navController,
                            viewModel = ScreenSignUpViewModel(
                                getApplicationInstance().interactorSignUpDomain
                            )
                        )
                    }
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
//        ApostasEsportivasTheme {
//            Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background).fillMaxSize()) {
//                Box(modifier = Modifier.background(color = Color.Blue).size(100.dp))
//            }
//        }
}