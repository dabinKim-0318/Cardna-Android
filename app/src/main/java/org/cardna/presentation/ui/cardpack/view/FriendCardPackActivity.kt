package org.cardna.presentation.ui.cardpack.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.cardna.R
import com.example.cardna.databinding.ActivityFriendCardPackBinding
import dagger.hilt.android.AndroidEntryPoint
import org.cardna.presentation.base.BaseViewUtil
import org.cardna.presentation.ui.cardpack.viewmodel.CardPackViewModel

@AndroidEntryPoint
class FriendCardPackActivity : BaseViewUtil.BaseAppCompatActivity<ActivityFriendCardPackBinding>(R.layout.activity_friend_card_pack) {
    private var id: Int = 0
    var name: String = "지우"

  //  private val cardPackViewModel: CardPackViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        setDefaultFragment()
    }

    override fun initView() {
        id = intent.getIntExtra("id", 0)
        //cardPackViewModel.setUserId(id)
        //      name = intent.getStringExtra("name") ?: ""

    }


    //디폴트로 연결되어 있을 Fragment 지정
    private fun setDefaultFragment() {
/*        val bundle = Bundle()
        bundle.putInt("id", id)
        bundle.putString("name", name)*/

        val cardPackFragment = CardPackFragment()
        //       cardPackFragment.arguments = bundle
        setFragmentWith(cardPackFragment)
    }

    //Fragment를 실질적으로 교체시키기 위한 메소드
    private fun setFragmentWith(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fcv_friend, fragment)
            .commit()
    }
}