package com.ovkoc.cavit.common

import android.content.Context
import com.ovkoc.cavit.common.network.RetrofitService
import com.ovkoc.cavit.network.CoronaApiService
import com.ovkoc.cavit.ui.home.HomePresenter
import org.koin.core.module.Module
import org.koin.dsl.module

class KoinModules {
    companion object{

        fun get(applicationContext: Context) : Module {

            return module {
                single { RetrofitService() }
                single { CoronaApiService(get()) }

                factory { HomePresenter(get()) }
            }
        }
    }

}