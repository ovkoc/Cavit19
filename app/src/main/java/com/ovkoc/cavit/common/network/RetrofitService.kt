package com.ovkoc.cavit.common.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Header

class RetrofitService (){


    fun newRetrofit(headers: Array<Header>) : Retrofit{

        return Retrofit.Builder()
            .baseUrl("https://corona.lmao.ninja/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }


}