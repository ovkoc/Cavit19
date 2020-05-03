package com.ovkoc.cavit.ui.home

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ovkoc.cavit.common.base.BaseViewModel
import com.ovkoc.cavit.common.network.model.CountryData
import com.ovkoc.cavit.ui.home.model.CountryUIModel
import com.ovkoc.cavit.ui.home.model.CountryUIModelMapper
import io.reactivex.Observable
import org.koin.core.inject
import com.ovkoc.cavit.common.extensions.register
import nurisezgin.com.rxtrash.RxTrash

class HomeViewModel : BaseViewModel() {

    private val tag = javaClass.simpleName
    private var _uiData = MutableLiveData<List<CountryUIModel>>()
    val uiData: LiveData<List<CountryUIModel>>
        get() = _uiData

    private lateinit var masterData: List<CountryUIModel>

    private val presenter: HomePresenter by inject()
    fun getData() {
        setUI(true, error = false)
        presenter.getCountriesData(::onCountriesDataReceived, ::onCountriesDataReceiveFailed)
    }

    private fun onCountriesDataReceived(countries: List<CountryData>) {
        setUI(false, error = false)

        val data =
            CountryUIModelMapper().toUICountryList(countries).sortedByDescending { it.active }
        _uiData.value = data
        if (!::masterData.isInitialized) {
            masterData = data
        }

    }

    fun filterUIData(key: String) {
        if (key.isNotEmpty()) {
            Observable.fromIterable(masterData)
                .filter {
                    if (it.country != null) {
                        it.country.contains(key, true)
                    } else {
                        true
                    }
                }
                .collect({ ArrayList<CountryUIModel>() }, { list, item -> list.add(item) })
                .toObservable().register(tag,
                    { _uiData.value = it },
                    { _uiData.value = masterData }
                )
        } else {
            _uiData.value = masterData
        }

    }

    private fun onCountriesDataReceiveFailed(throwable: Throwable) {
        setUI(false, error = true)
    }

    override fun retry(view: View?) {
        getData()
    }

    override fun onCleared() {
        super.onCleared()
        RxTrash.getInstance().clear { tag, _ -> tag == tag }
    }
}