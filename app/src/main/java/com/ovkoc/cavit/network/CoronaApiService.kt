package com.ovkoc.cavit.network

import com.ovkoc.cavit.common.network.RetrofitService
import retrofit2.http.Header

class CoronaApiService(private val retrofitService: RetrofitService) {

    private val headers: Array<Header> = arrayOf()

    private lateinit var api: CoronaApi

    fun getCoronaApi(): CoronaApi {

        if (!::api.isInitialized) {
            api = retrofitService
                .newRetrofit(headers = headers)
                .create(CoronaApi::class.java)
        }

        return api
    }

}