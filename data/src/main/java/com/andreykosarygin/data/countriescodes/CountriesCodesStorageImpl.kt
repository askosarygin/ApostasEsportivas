package com.andreykosarygin.data.countriescodes

import android.content.Context
import android.graphics.drawable.Drawable
import me.ibrahimsn.lib.PhoneNumberKit
import me.ibrahimsn.lib.internal.io.FileReader
import org.json.JSONArray

class CountriesCodesStorageImpl(
    private val context: Context
): CountriesCodesStorage {
    override suspend fun getAllCountries(): List<Country> {
        val phoneNumberKit = PhoneNumberKit.Builder(context).build()

        val allCountriesWithoutFlags = loadAllCountries(context)

        return allCountriesWithoutFlags.map { country ->
            val flagIcon = phoneNumberKit.getFlagIcon(country.iso2)

            val number = phoneNumberKit.getExampleNumber(country.iso2)
            val formattedPhoneNumber = phoneNumberKit.formatPhoneNumber(
                "${number!!.countryCode}${number.nationalNumber}",
                country.iso2
            )
            val formattedPhoneNumberWithoutCode = formattedPhoneNumber!!.split("+${number.countryCode}").last().trim()

            val mask = buildString {
                formattedPhoneNumberWithoutCode.forEach {
                    if (it.isDigit()) {
                        append('0')
                    } else {
                        append(it)
                    }
                }
            }

            Country(
                flagIcon,
                number.countryCode!!,
                country.name,
                mask,
                number.nationalNumber!!.toString().length
            )
        }
    }

    private fun loadAllCountries(context: Context): List<me.ibrahimsn.lib.api.Country> {
        return FileReader.readAssetFile(context, PhoneNumberKit.ASSET_FILE_NAME).toCountryList()
    }

    private fun String?.toCountryList(): List<me.ibrahimsn.lib.api.Country> {
        val countries = mutableListOf<me.ibrahimsn.lib.api.Country>()
        try {
            val json = JSONArray(this)
            for (i in 0 until json.length()) {
                val country = json.getJSONObject(i)
                countries.add(
                    me.ibrahimsn.lib.api.Country(
                        iso2 = country.getString("iso2"),
                        name = country.getString("name"),
                        code = country.getInt("code")
                    )
                )
            }
        } catch (e: Exception) {
            // ignored
        }
        return countries
    }

    data class Country(
        val flagIcon: Drawable?,
        val code: Int,
        val name: String,
        val mask: String,
        val phoneNumberLength: Int
    )
}