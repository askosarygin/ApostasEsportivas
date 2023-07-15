package com.andreykosarygin.signup_domain

import com.andreykosarygin.common.CountryCodeInfo

interface Repository {
    suspend fun loadCountriesCodesFromStorage(): List<CountryCodeInfo>
}