package com.oleksandrbumbyk.testassignment.presentation.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.oleksandrbumbyk.testassignment.presentation.util.SingleLiveData
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.plusAssign

@Suppress("ConvertSecondaryConstructorToPrimary")
@SuppressLint("StaticFieldLeak")
abstract class BaseAndroidViewModel : AndroidViewModel {

    open val loading = MutableLiveData<Boolean>()
    open val error = SingleLiveData<String>()

    protected val context: Context

    constructor(application: Application) : super(application) {
        this.context = application
    }

    private val disposables = CompositeDisposable()

    fun addDisposable(disposable: Disposable): Disposable {
        disposables += disposable
        return disposable
    }

    override fun onCleared() {
        disposables.dispose()
    }
}
