package com.ovkoc.cavit.ui.home

import com.ovkoc.cavit.common.base.BasePresenter
import com.ovkoc.cavit.common.network.model.CountryData
import com.ovkoc.cavit.common.extensions.register
import com.ovkoc.cavit.network.CoronaApiService
import nurisezgin.com.rxtrash.RxTrash

class HomePresenter(private val coronaApiService: CoronaApiService) : BasePresenter() {

    private val tag = javaClass.simpleName

    fun getCountriesData(
        success: (ArrayList<CountryData>) -> Unit,
        failure: (Throwable) -> Unit
    ) {
        coronaApiService.getCoronaApi().getCountriesData()
            .register(tag,
                {
                    success(it)
                },
                {
                    failure(it)
                })
    }

    override fun onDetached() {
        RxTrash.getInstance().clear { tag, _ -> tag == tag }
    }

}