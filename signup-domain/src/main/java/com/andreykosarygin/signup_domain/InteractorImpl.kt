package com.andreykosarygin.signup_domain

import com.andreykosarygin.common.CountryCodeInfo
import com.andreykosarygin.signup_domain.usecases.LoadCountriesCodesUseCase

class InteractorImpl(
    private val loadCountriesCodesUseCase: LoadCountriesCodesUseCase
) : Interactor {
    override suspend fun loadCountriesCodes(): List<CountryCodeInfo> =
        loadCountriesCodesUseCase.execute()
}