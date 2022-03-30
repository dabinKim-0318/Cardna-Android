package org.cardna.presentation.ui.setting.view

import android.os.Bundle
import com.example.cardna.R
import com.example.cardna.databinding.ActivityPrivacyPolicyBinding
import dagger.hilt.android.AndroidEntryPoint
import org.cardna.presentation.base.BaseViewUtil

@AndroidEntryPoint
class PrivacyPolicyActivity : BaseViewUtil.BaseAppCompatActivity<ActivityPrivacyPolicyBinding>(R.layout.activity_privacy_policy) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun initView() {
    }
}