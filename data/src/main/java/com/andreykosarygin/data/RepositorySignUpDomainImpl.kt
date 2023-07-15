package com.andreykosarygin.data

import com.andreykosarygin.common.CountryCodeInfo
import com.andreykosarygin.data.countriescodes.CountriesCodesStorage
import com.andreykosarygin.signup_domain.Repository

class RepositorySignUpDomainImpl(
    private val countriesCodesStorage: CountriesCodesStorage
) : Repository {
    override suspend fun loadCountriesCodesFromStorage(): List<CountryCodeInfo> {
        val countriesCodes = countriesCodesStorage.getAllCountries()

        return countriesCodes.map {
            CountryCodeInfo(
                it.flagIcon,
                it.code,
                it.name,
                it.mask,
                it.phoneNumberLength
            )
        }
    }
}