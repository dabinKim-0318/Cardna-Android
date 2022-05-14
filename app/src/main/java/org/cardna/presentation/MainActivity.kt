package org.cardna.presentation

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import dagger.hilt.android.AndroidEntryPoint
import org.cardna.R
import org.cardna.databinding.ActivityMainBinding
import org.cardna.presentation.base.BaseViewUtil
import org.cardna.presentation.ui.alarm.view.AlarmActivity
import org.cardna.presentation.ui.cardpack.view.CardCreateActivity
import org.cardna.presentation.ui.cardpack.view.CardPackFragment
import org.cardna.presentation.ui.cardpack.view.CardYouStoreActivity
import org.cardna.presentation.ui.detailcard.view.DetailCardActivity
import org.cardna.presentation.ui.insight.view.InsightFragment
import org.cardna.presentation.ui.maincard.view.MainCardFragment
import org.cardna.presentation.ui.mypage.view.MyPageFragment
import org.cardna.presentation.util.StatusBarUtil
import org.cardna.presentation.util.replace
import org.cardna.ui.cardpack.BottomDialogCardFragment
import timber.log.Timber

@AndroidEntryPoint
class MainActivity :
    BaseViewUtil.BaseAppCompatActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val mainCardFragment: MainCardFragment by lazy { MainCardFragment() }
    private val insightFragment: InsightFragment by lazy { InsightFragment() }
    private val myPageFragment: MyPageFragment by lazy { MyPageFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()


    }


    override fun initView() {
        initBottomNavigation()
        setBottomNavigationSelectListener()
        initDynamicLink()
    }

    private fun initBottomNavigation() {
        replace(R.id.fcv_main, mainCardFragment)
        binding.bnvMain.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_bottom_maincard -> {
                    supportFragmentManager.popBackStack()
                    StatusBarUtil.setStatusBar(this, Color.BLACK)
                    replace(R.id.fcv_main, mainCardFragment)
                    return@setOnItemSelectedListener true
                }
                R.id.menu_bottom_cardpack -> {
                    supportFragmentManager.popBackStack()
                    StatusBarUtil.setStatusBar(this, Color.BLACK)
                    replace(R.id.fcv_main, CardPackFragment())
                    return@setOnItemSelectedListener true
                }
                R.id.menu_bottom_insight -> {
                    supportFragmentManager.popBackStack()
                    StatusBarUtil.setStatusBar(this, Color.BLACK)
                    replace(R.id.fcv_main, insightFragment)
                    return@setOnItemSelectedListener true
                }
                else -> {
                    supportFragmentManager.popBackStack()
                    StatusBarUtil.setStatusBar(this, Color.BLACK)
                    replace(R.id.fcv_main, myPageFragment)
                    return@setOnItemSelectedListener true
                }
            }
        }
    }

    private fun setBottomNavigationSelectListener() {
        binding.bnvMain.itemIconTintList = null
        binding.bnvMain.selectedItemId = R.id.menu_bottom_maincard
    }

    // cardPackFragment 의 + 버튼을 눌렀을 때, 이 메서드 실행
// 즉, MainActivity 에서 BottomSheetDialog 를 띄워주는 메서드
    fun showBottomDialogCardFragment() {
        // 바텀싯 다이얼로그가 뜬 후, 카드나 or 카드너를 선택했을 때, 그거에 따라 어떤 액티비티를 띄워줘야 하는지를 명세한 Fragment 정의하고
        val bottomDialogCardFragment = BottomDialogCardFragment {
            when (it) {
                BaseViewUtil.CARD_ME -> {
                    // 카드나 작성 액티비티로 이동 => 카드나임을 알 수 있도록 intent로 정보전달
                    val intent = Intent(this, CardCreateActivity::class.java).apply {
                        putExtra(BaseViewUtil.IS_CARD_ME_OR_YOU, true) // 내 카드나 작성 or 친구 카드너 작성
                        // id, name 안넘겨주면, 알아서 null 로 setting
                    }
                    startActivity(intent)
                }
                BaseViewUtil.CARD_YOU -> {
                    // 내 카드너 보관함으로 이동
                    val intent = Intent(this, CardYouStoreActivity::class.java).apply {
                        putExtra(BaseViewUtil.IS_CARD_ME_OR_YOU, false) // 이거 꼭 넘겨줘야 함 ?
                    }
                    startActivity(intent)
                }
            }
        }
        bottomDialogCardFragment.show(supportFragmentManager, bottomDialogCardFragment.tag)
    }

    /** DynamicLink */
    private fun initDynamicLink() {
        val dynamicLinkData = intent.extras
        if (dynamicLinkData != null) {
            //상세로 가나 카드너보관함으로가나 ?
            if (dynamicLinkData.get("body").toString().contains("작성")) {
                startActivity(
                    Intent(this, DetailCardActivity::class.java).putExtra(BaseViewUtil.CARD_ID, dynamicLinkData.get("uniId").toString().toInt())
                )
            } else {
                Timber.e(dynamicLinkData.get("uniId").toString())
                startActivity(Intent(this, AlarmActivity::class.java).apply {
                    //         putExtra("uniId", dynamicLinkData.get("uniId").toString())
                })
            }
        }
    }
}