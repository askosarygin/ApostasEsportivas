package com.andreykosarygin.data.countriescodes

interface CountriesCodesStorage {
    suspend fun getAllCountries(): List<CountriesCodesStorageImpl.Country>
}