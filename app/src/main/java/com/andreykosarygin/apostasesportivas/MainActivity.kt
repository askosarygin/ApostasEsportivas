package com.andreykosarygin.apostasesportivas

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.andreykosarygin.common.Routes
import com.andreykosarygin.common.ui.theme.ApostasEsportivasTheme
import com.andreykosarygin.companies_ui.screen_companies.ScreenCompanies
import com.andreykosarygin.companies_ui.screen_companies.ScreenCompaniesViewModel
import com.andreykosarygin.data.RepositorySignUpDomainImpl
import com.andreykosarygin.data.countriescodes.CountriesCodesStorageImpl
import com.andreykosarygin.signup_domain.InteractorImpl
import com.andreykosarygin.signup_domain.usecases.LoadCountriesCodesUseCase
import com.andreykosarygin.signup_ui.screen_signup.ScreenSignUp
import com.andreykosarygin.signup_ui.screen_signup.ScreenSignUpViewModel
import com.andreykosarygin.signup_ui.screen_terms.ScreenTerms
import com.andreykosarygin.signup_ui.screen_terms.ScreenTermsViewModel

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
                        ScreenSignUp(
                            navController = navController,
                            viewModel = ScreenSignUpViewModel(
                                getApplicationInstance().interactorSignUpDomain
                            )
                        )
                    }

                    composable(route = Routes.SCREEN_TERMS) {
                        ScreenTerms(
                            navController = navController,
                            viewModel = ScreenTermsViewModel()
                        )
                    }

                    composable(route = Routes.SCREEN_COMPANIES) {
                        ScreenCompanies(
                            navController = navController,
                            viewModel = ScreenCompaniesViewModel()
                        )
                    }
                }

            }
        }
    }
}