package com.andreykosarygin.signup_domain.usecases

import com.andreykosarygin.common.CountryCodeInfo
import com.andreykosarygin.signup_domain.Repository

class LoadCountriesCodesUseCase(
    private val repository: Repository
) {
    suspend fun execute(): List<CountryCodeInfo> = repository.loadCountriesCodesFromStorage()
}