package com.cedricakrou.artisanat.application.di.common

import com.cedricakrou.artisanat.application.di.annotations.ActivityScope
import com.cedricakrou.artisanat.presentation.common.RootBaseActivity
import javax.inject.Inject

@ActivityScope
class AppRouter @Inject constructor( private val activity: RootBaseActivity)