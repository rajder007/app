package com.exaple.tamzaczyk.repository

import retrofit2.Response

class CountryRepository {
    suspend fun getCountryResponse(code: String): Response<List<CountryResponse>> =
        CountryService.countryService.getCountry(code)
    suspend fun getCountriesResponse(): Response<List<CountryResponse>> =
        CountryService.countryService.getCountries()
}