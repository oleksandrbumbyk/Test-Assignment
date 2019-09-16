package com.oleksandrbumbyk.testassignment.presentation.view

import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.oleksandrbumbyk.testassignment.R
import com.oleksandrbumbyk.testassignment.presentation.adapter.binding.UserBinder
import com.oleksandrbumbyk.testassignment.presentation.viewmodel.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : BaseFragment<ProfileViewModel>() {

    override val layoutRes = R.layout.fragment_profile

    override val viewModelClass = ProfileViewModel::class.java

    override fun initObservers() {
        observeLoading()
        observeUser()
        observeCallAction()
    }

    override fun initView() {
        toolbar.setNavigationOnClickListener { navigator.onProfileGoBack(findNavController()) }
        tvPhone.setOnClickListener { viewModel.callUser() }
        ivActionCall.setOnClickListener { viewModel.callUser() }
    }

    private fun observeLoading() {
        viewModel.loading.observe(this, Observer { loading ->
            progress_bar.visibility = if (loading == true) View.VISIBLE else View.INVISIBLE
        })
    }

    private fun observeUser() {
        viewModel.user.observe(this, Observer { user ->
            UserBinder.bindImage(activity, ivAvatar, user)
            UserBinder.bindAge(activity, tvAge, user)
            UserBinder.bindLocation(activity, tvLocation, user)
            UserBinder.bindName(tvName, user)
            UserBinder.bindEmail(tvEmail, user)
            UserBinder.bindPhone(activity, tvPhone, user)
            UserBinder.bindGender(activity, tvGender, user)
            UserBinder.bindBirthday(activity, tvBirthday, user)
        })
    }

    private fun observeCallAction() {
        viewModel.actionCall.observe(this, Observer { number ->
            if (number != null) navigator.onProfileOpenCall(activity, findNavController(), number)
        })
    }
}
