package com.ovkoc.cavit.ui.home.model

import com.ovkoc.cavit.common.network.model.CountryData

/**
 *  Created by ovkc on 26.04.2020
 */
class CountryUIModelMapper {

    fun toUICountryList(data: List<CountryData>?): List<CountryUIModel> {
        if (data.isNullOrEmpty()) {
            return emptyList()
        }

        return data.map(::toUIItem)
    }

    private fun toUIItem(item: CountryData): CountryUIModel {

        return CountryUIModel(
            country = item.country,
            flagImageUrl = item.countryInfo?.flag,
            cases = item.cases,
            active = item.active,
            deaths = item.deaths,
            recovered = item.recovered
        )
    }


}