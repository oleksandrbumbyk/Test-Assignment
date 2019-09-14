package com.oleksandrbumbyk.testassignment.domain

import io.reactivex.ObservableTransformer

abstract class UseCase internal constructor(protected val schedulers: Schedulers) {

    fun <T> applySchedulers() = ObservableTransformer<T, T> { upstream ->
        upstream
            .subscribeOn(schedulers.subscribeOn)
            .observeOn(schedulers.observeOn, true)
    }
}
