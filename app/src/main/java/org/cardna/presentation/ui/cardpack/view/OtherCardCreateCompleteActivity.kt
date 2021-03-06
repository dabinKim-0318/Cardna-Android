package org.cardna.presentation.ui.cardpack.view

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.text.set
import androidx.core.text.toSpannable
import land.sungbin.systemuicontroller.setSystemBarsColor
import org.cardna.R
import org.cardna.databinding.ActivityOtherCardCreateCompleteBinding
import org.cardna.presentation.MainActivity
import org.cardna.presentation.base.BaseViewUtil
import org.cardna.presentation.ui.maincard.view.MainCardActivity
import org.cardna.presentation.util.LinearGradientSpan
import org.cardna.presentation.util.StatusBarUtil
import org.cardna.presentation.util.shortToast
import timber.log.Timber


class OtherCardCreateCompleteActivity :
    BaseViewUtil.BaseAppCompatActivity<ActivityOtherCardCreateCompleteBinding>(R.layout.activity_other_card_create_complete) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun initView() {
        setTextGradient()
        setLottie(intent.getBooleanExtra(BaseViewUtil.IS_CARDPACK_OR_MAINCARD, BaseViewUtil.FROM_MAINCARD))
    }

    private fun setTextGradient() {
        val text = binding.tvOthercardcreateComplete.text.toString()
        val green = getColor(R.color.main_green)
        val purple = getColor(R.color.main_purple)
        val spannable = text.toSpannable()
        spannable[0..text.length] = LinearGradientSpan(text, text, green, purple)
        binding.tvOthercardcreateComplete.text = spannable
    }


    // 로티 띄워주고 이전 액티비티로 돌아가기
    private fun setLottie(isCardPackOrMainCard: Boolean){
        val handler = Handler(Looper.getMainLooper())
        if(isCardPackOrMainCard){  // 친구의 cardPack 에서 왔으면 FriendCardPackActivity 로 돌아가도록
            Timber.e("from cardpack")
            handler.postDelayed({
                var intent = Intent(this, FriendCardPackActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
                // FriendCardPackActivity 로 갈 때, CardCreateActivity pop하고 가기
                // 현재 FriendCardPackActivity -> CardCreateActivity -> 인데, C -> A로 가도록 intent 써서
            }, LOTTIE_VIEW_TIME) // 이는 CardCreateActivity가 얼마나 띄워주고 다시 main으로 갈 건지에 대한 시간, 로티가 뜨느 시간은 아님
        }
        else{ // 친구의 메인카드에서 왔는데
            if(intent.getBooleanExtra(BaseViewUtil.IS_CODE_OR_FRIEND, BaseViewUtil.FROM_FRIEND)){ // 1. 코드검색해서 왔을 경우
                // MainCardActivity 로 되돌아가줘야함
                handler.postDelayed({ // 친구의 mainCard 에서 왔으면 MainActivity 로 돌아가도록
                    var intent = Intent(this, MainCardActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    startActivity(intent)
                    // 진입점이 두개인데 어차피 둘다 MainActivity이므로
                    // MainActivity로 갈 때, CardCreateActivity pop하고 가기
                    // 현재 A -> B -> C인데, C -> A로 가도록 intent 써서
                }, LOTTIE_VIEW_TIME) // 이는 CardCreateActivity가 얼마나 띄워주고 다시 main으로 갈 건지에 대한 시간, 로티가 뜨느 시간은 아님

            }
            else{ // 2. MainActivity 의 마이페이지 프래그먼트
                handler.postDelayed({ // 친구의 mainCard 에서 왔으면 MainActivity 로 돌아가도록
                    var intent = Intent(this, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    startActivity(intent)
                    // 진입점이 두개인데 어차피 둘다 MainActivity이므로
                    // MainActivity로 갈 때, CardCreateActivity pop하고 가기
                    // 현재 A -> B -> C인데, C -> A로 가도록 intent 써서
                }, LOTTIE_VIEW_TIME) // 이는 CardCreateActivity가 얼마나 띄워주고 다시 main으로 갈 건지에 대한 시간, 로티가 뜨느 시간은 아님
            }
        }
    }

    companion object {
        const val LOTTIE_VIEW_TIME = 1670L
    }
}