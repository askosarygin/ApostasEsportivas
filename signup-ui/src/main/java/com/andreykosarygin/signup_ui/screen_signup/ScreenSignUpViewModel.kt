package com.andreykosarygin.signup_ui.screen_signup

import android.graphics.drawable.Drawable
import androidx.lifecycle.viewModelScope
import com.andreykosarygin.common.ApostasEsportivasViewModel
import com.andreykosarygin.common.ApostasEsportivasViewModelSingleLifeEvent
import com.andreykosarygin.common.CountryCodeInfo
import com.andreykosarygin.signup_domain.Interactor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ScreenSignUpViewModel(
    private val interactor: Interactor
) : ApostasEsportivasViewModel<ScreenSignUpViewModel.Model>(Model()) {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val countriesCodeList = interactor.loadCountriesCodes()
            updateCountriesCodeList(countriesCodeList = countriesCodeList)
        }
    }

    fun termsOfUseAndPrivacyPolicyClicked() {
        updateNavigationEvent(
            Model.NavigationSingleLifeEvent(
                Model.NavigationSingleLifeEvent.NavigationDestination.ScreenTerms
            )
        )
    }

    fun phoneNumberChanged(newPhoneNumber: String) {
        if (newPhoneNumber.length <= model.value.phoneNumberLength) {
            updatePhoneNumber(newPhoneNumber)
        }

        if (model.value.phoneNumber.length == model.value.phoneNumberLength) {
            updateButtonRegistrationEnabled(true)
        }

        if (model.value.phoneNumber.length < model.value.phoneNumberLength) {
            updateButtonRegistrationEnabled(false)
        }
    }

    fun countryCodeSelectionPressed() {
        updateShowCodesOfCountriesList(!model.value.showCodesOfCountriesList)
    }

    fun countryCodeSelected(countryCodeIndex: Int) {
        updatePhoneNumber("")
        updateButtonRegistrationEnabled(false)
        val country = model.value.countriesCodeList[countryCodeIndex]
        country.flagIcon?.let {
            updateCountryFlag(it)
        }
        updatePhoneCode("+${country.code}")
        updatePhoneMask(country.mask)
        updatePhoneNumberLength(country.phoneNumberLength)
        updateShowCodesOfCountriesList(false)
    }

    data class Model(
        val buttonRegistrationEnabled: Boolean = false,
        val showCodesOfCountriesList: Boolean = false,
        val phoneNumber: String = "",
        val phoneNumberLength: Int = 0,
        val countryFlag: Drawable? = null,
        val phoneCode: String = "Select country code",
        val phoneMask: String = "",
        val countriesCodeList: List<CountryCodeInfo> = listOf(),
        val whatCharInMaskIsPhoneNumber: Char = '0',
        val navigationEvent: NavigationSingleLifeEvent? = null
    ) {
        class NavigationSingleLifeEvent(
            navigateTo: NavigationDestination
        ) : ApostasEsportivasViewModelSingleLifeEvent<NavigationSingleLifeEvent.NavigationDestination>(
            navigateTo
        ) {
            enum class NavigationDestination {
                ScreenTerms,
                ScreenCompanies
            }
        }
    }

    private fun updateButtonRegistrationEnabled(buttonRegistrationEnabled: Boolean) {
        update {
            it.copy(
                buttonRegistrationEnabled = buttonRegistrationEnabled
            )
        }
    }

    private fun updateCountryFlag(countryFlag: Drawable?) {
        update {
            it.copy(
                countryFlag = countryFlag
            )
        }
    }

    private fun updatePhoneNumberLength(phoneNumberLength: Int) {
        update {
            it.copy(
                phoneNumberLength = phoneNumberLength
            )
        }
    }

    private fun updateCountriesCodeList(countriesCodeList: List<CountryCodeInfo>) {
        update {
            it.copy(
                countriesCodeList = countriesCodeList
            )
        }
    }

    private fun updateShowCodesOfCountriesList(showCodesOfCountriesList: Boolean) {
        update {
            it.copy(
                showCodesOfCountriesList = showCodesOfCountriesList
            )
        }
    }

    private fun updateWhatCharInMaskIsPhoneNumber(whatCharInMaskIsPhoneNumber: Char) {
        update {
            it.copy(
                whatCharInMaskIsPhoneNumber = whatCharInMaskIsPhoneNumber
            )
        }
    }

    private fun updatePhoneMask(phoneMask: String) {
        update {
            it.copy(
                phoneMask = phoneMask
            )
        }
    }

    private fun updatePhoneCode(phoneCode: String) {
        update {
            it.copy(
                phoneCode = phoneCode
            )
        }
    }

    private fun updatePhoneNumber(phoneNumber: String) {
        update {
            it.copy(
                phoneNumber = phoneNumber
            )
        }
    }

    private fun updateNavigationEvent(navigationEvent: Model.NavigationSingleLifeEvent) {
        update {
            it.copy(
                navigationEvent = navigationEvent
            )
        }
    }
}