package com.andreykosarygin.signup_ui.screen_signup

import com.andreykosarygin.common.ApostasEsportivasViewModel
import com.andreykosarygin.common.ApostasEsportivasViewModelSingleLifeEvent
import com.andreykosarygin.common.utils.phonenumberutil.PhoneNumberUtil

class ScreenSignUpViewModel(

) : ApostasEsportivasViewModel<ScreenSignUpViewModel.Model>(Model()) {

    fun phoneNumberChanged(newPhoneNumber: String) {
        updatePhoneNumber(newPhoneNumber)
    }

    fun countryCodeSelectionPressed() {
        updateShowCodesOfCountriesList(!model.value.showCodesOfCountriesList)
    }

    fun countryCodeSelected(countryCodeIndex: Int) {
        val country = model.value.countriesCodeList[countryCodeIndex]
        updatePhoneCode("+${country.code}")
        updatePhoneMask(country.mask)
    }

    data class Model(
        val showCodesOfCountriesList: Boolean = false,
        val phoneNumber: String = "",
        val phoneCode: String = "Country code",
        val phoneMask: String = "",
        val countriesCodeList: List<PhoneNumberUtil.Country> =
//            listOf(),
            listOf(
                PhoneNumberUtil.Country(
                    null,
                    7,
                    "Russian Federation",
                    "000 000 00 00"
                ),
                PhoneNumberUtil.Country(
                    null,
                    7,
                    "Russian Federation",
                    "000 000 00 00"
                ),
                PhoneNumberUtil.Country(
                    null,
                    7,
                    "Russian Federation",
                    "000 000 00 00"
                ),
                PhoneNumberUtil.Country(
                    null,
                    7,
                    "Russian Federation",
                    "000 000 00 00"
                ),
                PhoneNumberUtil.Country(
                    null,
                    7,
                    "Russian Federation",
                    "000 000 00 00"
                ),
                PhoneNumberUtil.Country(
                    null,
                    7,
                    "Russian Federation",
                    "000 000 00 00"
                ),
                PhoneNumberUtil.Country(
                    null,
                    7,
                    "Russian Federation",
                    "000 000 00 00"
                ),
                PhoneNumberUtil.Country(
                    null,
                    7,
                    "Russian Federation",
                    "000 000 00 00"
                ),
                PhoneNumberUtil.Country(
                    null,
                    7,
                    "Russian Federation",
                    "000 000 00 00"
                ),
                PhoneNumberUtil.Country(
                    null,
                    7,
                    "Russian Federation",
                    "000 000 00 00"
                )
            ),
        val whatCharInMaskIsPhoneNumber: Char = '0',
        val navigationEvent: NavigationSingleLifeEvent? = null
    ) {
        class NavigationSingleLifeEvent(
            navigateTo: NavigationDestination
        ) : ApostasEsportivasViewModelSingleLifeEvent<NavigationSingleLifeEvent.NavigationDestination>(
            navigateTo
        ) {
            enum class NavigationDestination {

            }
        }
    }

    private fun updateCountriesCodeList(countriesCodeList: List<PhoneNumberUtil.Country>) {
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