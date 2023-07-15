package com.andreykosarygin.common.utils.phonenumberutil

import android.content.Context
import android.graphics.drawable.Drawable
import me.ibrahimsn.lib.PhoneNumberKit
import me.ibrahimsn.lib.api.Country
import me.ibrahimsn.lib.internal.io.FileReader
import org.json.JSONArray

class PhoneNumberUtil {

    companion object {
        fun getAllCountries(context: Context): List<Country> {
            val phoneNumberKit = PhoneNumberKit.Builder(context).build()

            val allCountriesWithoutFlags = loadAllCountries(context)

            return allCountriesWithoutFlags.map {
                val flagIcon = phoneNumberKit.getFlagIcon(it.iso2)

                val number = phoneNumberKit.getExampleNumber(it.iso2)
                val mask = phoneNumberKit.formatPhoneNumber(
                    "${number!!.countryCode}${number.nationalNumber}",
                    it.iso2
                )!!.split(it.code.toString()).last().trim()

                Country(
                    flagIcon,
                    it.code,
                    it.name,
                    mask
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
                        Country(
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
    }

    data class Country(
        val flagIcon: Drawable?,
        val code: Int,
        val name: String,
        val mask: String
    )
}