package org.cardna.presentation.ui.setting.view

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import com.example.cardna.R
import com.example.cardna.databinding.ActivitySettingBinding
import dagger.hilt.android.AndroidEntryPoint
import org.cardna.data.local.singleton.CardNaRepository
import org.cardna.presentation.base.BaseViewUtil
import org.cardna.presentation.ui.setting.viewmodel.SettingViewModel
import org.cardna.presentation.util.StatusBarUtil
import org.cardna.presentation.util.showCustomDialog

@AndroidEntryPoint
class SettingActivity : BaseViewUtil.BaseAppCompatActivity<ActivitySettingBinding>(R.layout.activity_setting) {

    private val settingViewModel: SettingViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun initView() {
        StatusBarUtil.setStatusBar(this, Color.BLACK)
        setClickListener()
        setAlarmSwitchClickListener()
    }

    @SuppressLint("ResourceType")
    private fun setAlarmSwitchClickListener() {
        with(binding) {
            switchBtnSetting.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) ivSettingAlarm.setBackgroundResource(R.drawable.bg_switch_track_on)
                else ivSettingAlarm.setBackgroundResource(R.drawable.bg_switch_track_off)
            }
        }
    }

    private fun setClickListener() {
        with(binding) {
            tvSettingAppInfoVersion.setOnClickListener {
                startActivity(Intent(this@SettingActivity, VersionInfoActivity::class.java))
            }
            tvSettingAppInfoDeveloper.setOnClickListener {
                startActivity(Intent(this@SettingActivity, DeveloperInfoActivity::class.java))
            }
            tvSettingEtcSecession.setOnClickListener {
                startActivity(Intent(this@SettingActivity, SecessionActivity::class.java))
            }
            tvSettingEtcLogout.setOnClickListener {
                showLogOutDialog()
            }
        }
    }

    @SuppressLint("ResourceType")
    private fun showLogOutDialog() {
        val dialog = this.showCustomDialog(R.layout.dialog_logout)
        val confirmBtn = dialog.findViewById<Button>(R.id.tv_lougout_dialog_confirm)
        val cancelBtn = dialog.findViewById<Button>(R.id.tv_logout_dialog_cancel)

        confirmBtn.setOnClickListener {
            //     CardNaRepository.userToken=""  //로그아웃 시 유저토큰을 없앰
            CardNaRepository.kakaoUserlogOut = true
            dialog.dismiss()
        }

        cancelBtn.setOnClickListener {
            dialog.dismiss()
        }
    }
}

