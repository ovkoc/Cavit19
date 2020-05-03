package com.ovkoc.cavit.network

import com.ovkoc.cavit.common.network.model.CountryData
import io.reactivex.Observable
import retrofit2.http.GET

interface CoronaApi{

    @GET("countries/turkey")
    fun getDataForCountry()
            : Observable<CountryData>

    @GET("countries")
    fun getCountriesData()
            : Observable<ArrayList<CountryData>>


}