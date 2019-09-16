package com.oleksandrbumbyk.testassignment.presentation.view

import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.oleksandrbumbyk.testassignment.R
import com.oleksandrbumbyk.testassignment.presentation.adapter.ItemListener
import com.oleksandrbumbyk.testassignment.presentation.adapter.LoadMoreListener
import com.oleksandrbumbyk.testassignment.presentation.adapter.RecyclerAdapter
import com.oleksandrbumbyk.testassignment.presentation.adapter.item.UserItem
import com.oleksandrbumbyk.testassignment.presentation.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment<HomeViewModel>() {

    override val layoutRes = R.layout.fragment_home

    override val viewModelClass = HomeViewModel::class.java

    private val itemListener = object : ItemListener {
        override fun onUserClick(item: UserItem) {
            viewModel.selectUser(item.user)
        }
    }

    private val loadMoreListener = object : LoadMoreListener {
        override fun loadMoreItems() {
            viewModel.loadNextPage()
        }
    }

    private val userAdapter = RecyclerAdapter(itemListener = itemListener, loadMoreListener = loadMoreListener)

    override fun initObservers() {
        observeLoading()
        observeUsers()
        observeSelectResult()
    }

    override fun initView() {
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

    private fun observeSelectResult() {
        viewModel.userSelectResult.observe(this, Observer { result ->
            if (result == true) navigator.onHomeOpenProfile(findNavController())
        })
    }
}
