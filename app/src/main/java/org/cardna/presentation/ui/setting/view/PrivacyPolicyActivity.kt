package org.cardna.presentation.ui.setting.view

import android.graphics.Color
import android.os.Bundle
import org.cardna.R
import org.cardna.databinding.ActivityPrivacyPolicyBinding
import dagger.hilt.android.AndroidEntryPoint
import land.sungbin.systemuicontroller.setSystemBarsColor
import org.cardna.presentation.base.BaseViewUtil
import org.cardna.presentation.util.StatusBarUtil

@AndroidEntryPoint
class PrivacyPolicyActivity :
    BaseViewUtil.BaseAppCompatActivity<ActivityPrivacyPolicyBinding>(R.layout.activity_privacy_policy) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun initView() {
    }
}