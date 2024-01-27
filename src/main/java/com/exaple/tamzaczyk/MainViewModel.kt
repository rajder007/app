package com.exaple.tamzaczyk

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exaple.tamzaczyk.repository.CountryRepository
import com.exaple.tamzaczyk.repository.CountryResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel : ViewModel() {

    private val countryRepository = CountryRepository()

    private val mutableCountriesData = MutableLiveData<UiState<List<CountryResponse>>>()
    val immutableCountriesData: LiveData<UiState<List<CountryResponse>>> = mutableCountriesData

    data class UiState<T>(
        val data: T? = null,
        val isLoading: Boolean = false,
        val error: String? = null
    )
    fun getData(){
        viewModelScope.launch(Dispatchers.IO){
            try{
                mutableCountriesData.postValue(UiState(isLoading = true, error = null))
                val request = countryRepository.getCountriesResponse()
                val countries = request.body()
                mutableCountriesData.postValue(UiState(isLoading = false, data=countries, error = null))
            }
            catch(e:Exception){
                mutableCountriesData.postValue(UiState(isLoading = false, error = e.message));
            }
        }
    }
}

class DetailViewModel : ViewModel() {
    private val countryRepository = CountryRepository();

    private val mutableCountryData =  MutableLiveData<UiState<List<CountryResponse>>>()
    val immutableCountryData: LiveData<UiState<List<CountryResponse>>> = mutableCountryData

    data class UiState<T>(
        val data: T? = null,
        val isLoading: Boolean = false,
        val error: String? = null
    )

    fun getData(code: String){
        viewModelScope.launch(Dispatchers.IO){
            try{
                mutableCountryData.postValue(UiState(isLoading = true, error = null))
                val request = countryRepository.getCountryResponse(code)
                val countries = request.body()
                mutableCountryData.postValue(UiState(isLoading = false, data=countries, error = null))
            }
            catch(e:Exception){
                mutableCountryData.postValue(UiState(isLoading = false, error = e.message));
            }
        }
    }
}