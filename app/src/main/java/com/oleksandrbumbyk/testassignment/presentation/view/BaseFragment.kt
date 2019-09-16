package com.oleksandrbumbyk.testassignment.presentation.view

import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.oleksandrbumbyk.testassignment.R
import com.oleksandrbumbyk.testassignment.presentation.navigation.Navigator
import com.oleksandrbumbyk.testassignment.presentation.util.lazyThreadSafetyNone
import com.oleksandrbumbyk.testassignment.presentation.viewmodel.BaseAndroidViewModel
import dagger.android.support.DaggerAppCompatActivity
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment<V : BaseAndroidViewModel> : DaggerFragment() {

    abstract val viewModelClass: Class<V>

    abstract val layoutRes: Int

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var navigator: Navigator

    open val orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    protected val viewModel by lazyThreadSafetyNone {
        ViewModelProviders.of(this, viewModelFactory).get(viewModelClass)
    }

    protected lateinit var activity: DaggerAppCompatActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = context as DaggerAppCompatActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutRes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObservers()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        onStartDataLoading()
    }

    override fun onResume() {
        super.onResume()
        activity.requestedOrientation = orientation
    }

    protected open fun onStartDataLoading() {}

    protected abstract fun initView()

    protected abstract fun initObservers()

    protected fun initSwipeRefresh(
        swipeRefreshLayout: SwipeRefreshLayout,
        listener: SwipeRefreshLayout.OnRefreshListener
    ) {
        swipeRefreshLayout.setColorSchemeColors(ContextCompat.getColor(activity, R.color.colorAccent))
        swipeRefreshLayout.setOnRefreshListener(listener)
    }
}
