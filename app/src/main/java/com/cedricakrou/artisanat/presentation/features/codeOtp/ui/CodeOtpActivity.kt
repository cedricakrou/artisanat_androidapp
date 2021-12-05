package com.cedricakrou.artisanat.presentation.features.codeOtp.ui

import com.cedricakrou.artisanat.presentation.common.BaseActivity
import com.cedricakrou.artisanat.presentation.features.codeOtp.CodeOtpAction
import com.cedricakrou.artisanat.presentation.features.codeOtp.CodeOtpIntent
import com.cedricakrou.artisanat.presentation.features.codeOtp.CodeOtpState
import com.cedricakrou.artisanat.presentation.features.codeOtp.CodeOtpViewModel


class CodeOtpActivity : BaseActivity<
        CodeOtpIntent,
        CodeOtpAction,
        CodeOtpState,
        CodeOtpViewModel>( CodeOtpViewModel::class.java ) {

    override fun getLayoutResId(): Int {
        TODO("Not yet implemented")
    }

    override fun initUI() {
        TODO("Not yet implemented")
    }

    override fun initDATA() {
        TODO("Not yet implemented")
    }

    override fun initEVENT() {
        TODO("Not yet implemented")
    }

    override fun render(state: CodeOtpState) {
        TODO("Not yet implemented")
    }
}