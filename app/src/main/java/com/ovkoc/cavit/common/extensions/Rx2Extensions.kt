package com.ovkoc.cavit.common.extensions

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import nurisezgin.com.rxtrash.RxTrash

fun <T> Observable<T>.register(
    tag: String,
    onSuccess: (response: T) -> Unit,
    onError: (error: Throwable) -> Unit
) {
    val disposable = this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            {onSuccess(it)},
            {onError(it)}
        )

    RxTrash.getInstance().add(tag, disposable)
}

fun <T> Observable<T>.register(
    tag: String,
    onSuccess: (response: T) -> Unit
) {
    val disposable = this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            {onSuccess(it)},
            {},
            { RxTrash.getInstance().clear { x, y -> x == tag}}
        )

    RxTrash.getInstance().add(tag, disposable)
}
