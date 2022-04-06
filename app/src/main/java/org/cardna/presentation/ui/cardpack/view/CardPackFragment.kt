package org.cardna.presentation.ui.cardpack.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.cardna.R
import com.example.cardna.databinding.CardpackCustomTablayoutBinding
import com.example.cardna.databinding.FragmentCardPackBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import org.cardna.presentation.MainActivity
import org.cardna.presentation.base.BaseViewUtil
import org.cardna.presentation.ui.cardpack.adapter.CardPackTabLayoutAdapter
import org.cardna.presentation.ui.cardpack.viewmodel.CardPackViewModel

@AndroidEntryPoint
class CardPackFragment : BaseViewUtil.BaseFragment<FragmentCardPackBinding>(R.layout.fragment_card_pack) {

    var userId = 0

    private val cardPackViewModel: CardPackViewModel by activityViewModels()
    //카드팩 프래그먼트는 2개의 사이클에 붙게됨
    //1. 내가 내꺼볼때->메인엑티비티의 라이프사이클을 따라감 : 앱을 꺼야 뷰모델 파괴됨
    //2. 친구액티비티에 붙어있을때->친구액티비티 라이프 사이클을 따라감 : 친구액티비티 finish되어야 뷰모델 파괴됨
    //=>카드팩뷰모델은 2개 생성된다

    //내가 내꺼볼때는 메인 엑티비티 사이클로 생성된 뷰모델 생성되고 id 무조건 null임
    //친구 액티비티 사이클로 생성된 뷰모델은 친구액티비티가 finish되고나면 뷰모델도 파괴되니까 저절로 id는 null로 초기화됨

    private lateinit var cardPackTabLayoutAdapter: CardPackTabLayoutAdapter // tabLayout 에 data 띄워주는 adapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cardPackViewModel = cardPackViewModel
        binding.cardPackFragment = this
        initView()
    }

    override fun onResume() { // 카드팩프래그먼트에서 카드를 눌러 카드 상세페이지로 가서 삭제한다음 왔을 때, 카드팩의 카드들이 업데이트 되어야 하므로 onResume이 필요하다
        super.onResume()
        initData()
    }


    override fun initView() {
        initData()
        initCardPackAdapter()
        initCardPackTabLayout()
    }

    private fun initData() {
        //내가 내꺼볼때 생성된 뷰모델객체에서는 id=null로 데이터 가져옴
        //친구 액티비티를 타고 생성된 카드팩프래그먼트라면 뷰모델을 친구액티비티와와 함께 공유하고 있으니 이미 id는 친구껄로 세팅됨
        cardPackViewModel.updateCardMeList()
        setMakeCardIvListener()
    }

    private fun setMakeCardIvListener() {
        binding.ivAddCard.setOnClickListener {
            (activity as MainActivity).showBottomDialogCardFragment()
        }
    }

    private fun initCardPackAdapter() {
        val fragmentList: List<Fragment>
        fragmentList = listOf(
            CardMeFragment(),
            CardYouFragment()
        )
        cardPackTabLayoutAdapter = CardPackTabLayoutAdapter(this)
        cardPackTabLayoutAdapter.fragments.addAll(fragmentList)
        binding.vpCardpack.adapter = cardPackTabLayoutAdapter
    }

    private fun initCardPackTabLayout() {
        val tabLabel = listOf("카드나", "카드너")

        TabLayoutMediator(binding.tlCardpack, binding.vpCardpack) { tab, position ->
            tab.text = tabLabel[position]
        }.attach()

        binding.tlCardpack.getTabAt(0)?.customView = createTabLayout("카드나")
        binding.tlCardpack.getTabAt(1)?.customView = createTabLayout("카드너")

        for (position: Int in 0..binding.tlCardpack.tabCount) {
            if (binding.tlCardpack.getTabAt(position) != null) {
                binding.tlCardpack.setPaddingRelative(0, 0, 0, 0)
            }
        }
    }

    private fun createTabLayout(tabName: String): View { // 각 탭 레이아웃에 탭의 뷰 디자인 하는 메서드
        val tabBinding: CardpackCustomTablayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(requireContext()),
            R.layout.cardpack_custom_tablayout,
            null,
            false
        )

        with(tabBinding) {
            when (tabName) {
                "카드나" -> {
                    tvCardmeTab.text = tabName
                    isCardme = true
                    ivCardpackTab.setImageResource(R.drawable.ic_selector_cardpack_tab_cardme)
                    viewCardpackLine.setBackgroundResource(R.drawable.ic_selector_cardpack_tab_cardme_line)
                }

                "카드너" -> {
                    tvCardyouTab.text = tabName
                    isCardme = false
                    ivCardpackTab.setImageResource(R.drawable.ic_selector_cardpack_tab_cardyou)
                    viewCardpackLine.setBackgroundResource(R.drawable.ic_selector_cardpack_tab_cardyou_line)
                }
            }
        }
        return tabBinding.root
    }
}
