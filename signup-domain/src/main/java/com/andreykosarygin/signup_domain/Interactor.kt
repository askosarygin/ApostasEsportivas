package com.andreykosarygin.signup_domain

import com.andreykosarygin.common.CountryCodeInfo

interface Interactor {
    suspend fun loadCountriesCodes() : List<CountryCodeInfo>
}