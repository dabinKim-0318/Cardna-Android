package org.cardna.presentation.ui.cardpack.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cardna.R
import com.example.cardna.databinding.FragmentCardMeBinding
import dagger.hilt.android.AndroidEntryPoint
import org.cardna.presentation.base.BaseViewUtil
import org.cardna.presentation.ui.cardpack.adapter.CardPackMeRecyclerViewAdapter
import org.cardna.presentation.ui.cardpack.viewmodel.CardPackViewModel
import org.cardna.presentation.ui.detailcard.view.DetailCardActivity
import org.cardna.presentation.util.SpacesItemDecoration
import kotlin.math.roundToInt


@AndroidEntryPoint
class CardMeFragment : BaseViewUtil.BaseFragment<FragmentCardMeBinding>(R.layout.fragment_card_me) {
    private lateinit var cardPackMeRecyclerViewAdapter: CardPackMeRecyclerViewAdapter
    private val cardPackViewModel: CardPackViewModel by activityViewModels() // id,
//  private var isMyCard: Boolean = true // 유저 본인의 카드나에 접근하는건지, 타인의 카드나에 접근하는 건지 이는 나중에

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onResume() {
        super.onResume()
        initData()
    }

    override fun initView() {
        initCardMeRvAdapter()
        initData()
        setobserve()
    }

   private fun initData() {
        cardPackViewModel.updateCardMeList() // 카드나 카드들을 서버로부터 불러오기
    }


    // Adapter 생성
    private fun initCardMeRvAdapter() {
        cardPackMeRecyclerViewAdapter = CardPackMeRecyclerViewAdapter() { // 어댑터 초기화 =>
            val intent = Intent(requireContext(), DetailCardActivity::class.java).apply {
                putExtra(BaseViewUtil.CARD_ID, it.id) // 리사이클러뷰의 아이템 중 카드 선택시 그 카드의 id를 전달
                startActivity(this)
            }
        }

        with(binding) {
            rvCardme.adapter = cardPackMeRecyclerViewAdapter
            val gridLayoutManager = GridLayoutManager(requireContext(), 2)
            rvCardme.layoutManager = gridLayoutManager
            rvCardme.addItemDecoration(SpacesItemDecoration((12 * resources.displayMetrics.density).roundToInt())) // 화면 비율 조정

            // onResume 될 때, cardMeList 를 업데이트 시키고 cardMeList 가 변경되면, 이를 observe 해서 알아서 리사이클러뷰를 갱신해주도록
        }
    }

    fun setobserve() {
        cardPackViewModel.cardMeList?.observe(viewLifecycleOwner, Observer { it ->
            it?.let { cardPackMeRecyclerViewAdapter.submitList(it) }
        })
    }
}