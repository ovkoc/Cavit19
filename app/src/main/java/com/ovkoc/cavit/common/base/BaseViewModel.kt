package com.ovkoc.cavit.common.base

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.koin.core.KoinComponent

abstract class BaseViewModel : ViewModel(), KoinComponent {

    private var _loading = MutableLiveData<Int>()
    val loading: LiveData<Int>
        get() = _loading

    private var _error = MutableLiveData<Int>()
    val error: LiveData<Int>
        get() = _error

    private var _content = MutableLiveData<Int>()
    val content: LiveData<Int>
        get() = _content

    open fun retry(view: View?) { /*every viewModel does not have to implement me*/
    }

    fun setUI(loading: Boolean, error: Boolean) {
        _loading.value = if (loading) View.VISIBLE else View.GONE
        _error.value = if (error) View.VISIBLE else View.GONE
        _content.value = if (loading || error) View.GONE else View.VISIBLE
    }

}