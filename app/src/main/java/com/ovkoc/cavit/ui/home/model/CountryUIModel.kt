package com.ovkoc.cavit.ui.home.model

import com.google.gson.annotations.SerializedName

data class CountryUIModel(
    @SerializedName("country")
    val country: String?,
    @SerializedName("flagImageUrl")
    val flagImageUrl: String?,
    @SerializedName("cases")
    val cases: Int?,
    @SerializedName("active")
    val active: Int?,
    @SerializedName("deaths")
    val deaths: Int?,
    @SerializedName("recovered")
    val recovered: Int?
)