package com.oleksandrbumbyk.testassignment.presentation.view

import androidx.lifecycle.Observer
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.oleksandrbumbyk.testassignment.R
import com.oleksandrbumbyk.testassignment.presentation.adapter.ItemListener
import com.oleksandrbumbyk.testassignment.presentation.adapter.LoadMoreListener
import com.oleksandrbumbyk.testassignment.presentation.adapter.RecyclerAdapter
import com.oleksandrbumbyk.testassignment.presentation.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment<HomeViewModel>() {

    override val layoutRes = R.layout.fragment_home

    override val viewModelClass = HomeViewModel::class.java

    private val itemListener = object : ItemListener {}

    private val loadMoreListener = object : LoadMoreListener {
        override fun loadMoreItems() {
            viewModel.loadNextPage()
        }
    }

    private val userAdapter = RecyclerAdapter(itemListener = itemListener, loadMoreListener = loadMoreListener)

    override fun initObservers() {
        observeLoading()
        observeUsers()
    }

    override fun initView() {
        toolbar.title = activity.getString(R.string.home)
        toolbar.navigationIcon = null
        recycler_view.setHasFixedSize(true)
        recycler_view.adapter = userAdapter
        initSwipeRefresh(swipe_refresh_layout, SwipeRefreshLayout.OnRefreshListener { viewModel.refresh() })
    }

    private fun observeLoading() {
        viewModel.loading.observe(this, Observer { on -> swipe_refresh_layout.isRefreshing = on == true })
    }

    private fun observeUsers() {
        viewModel.list.observe(this, Observer { items -> userAdapter.resetItems(items) })
    }
}
