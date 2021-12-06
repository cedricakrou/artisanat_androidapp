package com.cedricakrou.artisanat.presentation.features.home.ui

import com.cedricakrou.artisanat.R
import com.cedricakrou.artisanat.presentation.common.BaseActivity

class HomeActivity : BaseActivity<
        HomeIntent,
        HomeAction,
        HomeState,
        HomeViewModel>( HomeViewModel::class.java )
{
    override fun getLayoutResId(): Int = R.layout.activity_home

    override fun initUI() {

    }

    override fun initDATA() {

    }

    override fun initEVENT() {
    }

    override fun render(state: HomeState) {

    }
}