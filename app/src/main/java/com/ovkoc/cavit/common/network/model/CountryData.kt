package com.ovkoc.cavit.common.network.model

import com.google.gson.annotations.SerializedName

data class CountryData(

    @SerializedName("updated")
    val updated: Long?,
    @SerializedName("country")
    val country: String?,
    @SerializedName("countryInfo")
    val countryInfo: CountyInfo?,
    @SerializedName("cases")
    val cases: Int?,
    @SerializedName("todayCases")
    val todayCases: Int?,
    @SerializedName("deaths")
    val deaths: Int?,
    @SerializedName("todayDeaths")
    val todayDeaths: Int?,
    @SerializedName("recovered")
    val recovered: Int?,
    @SerializedName("active")
    val active: Int?,
    @SerializedName("critical")
    val critical: Int?,
    @SerializedName("casesPerOneMillion")
    val casesPerOneMillion: Int?,
    @SerializedName("deathsPerOneMillion")
    val deathsPerOneMillion: Int?,
    @SerializedName("tests")
    val tests: Int?,
    @SerializedName("testsPerOneMillion")
    val testsPerOneMillion: Int?,
    @SerializedName("continent")
    val continent: String?
)