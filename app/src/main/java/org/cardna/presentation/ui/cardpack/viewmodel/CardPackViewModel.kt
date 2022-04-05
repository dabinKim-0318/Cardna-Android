package org.cardna.presentation.ui.cardpack.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.cardna.data.remote.model.card.ResponseCardMeData
import org.cardna.data.remote.model.insight.ResponseInsightData
import org.cardna.domain.repository.CardRepository
import org.cardna.presentation.ui.detailcard.view.DetailCardActivity
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class CardPackViewModel @Inject constructor(
    private val cardRepository: CardRepository, // 이렇게 쓰는 거 맞나
) : ViewModel() { // CardPack, CardYou, CardMeFragment 가 CardPackViewModel 공유

    // 어떤 id 의 사람의 카드팩 프래그먼트에 접근하는지
    private var _id: Int?=0
    val id: Int?
        get() = _id

    // 어떤 name 의 사람의 카드팩 프래그먼트에 접근하는지
    private var _name: String? = null
    val name: String?
        get() = _name

    // 그 사람의 카드팩의 총 카드 개수 => CardPackFragment 의 textView 에 바인딩
    private val _totalCardCnt = MutableLiveData<Int>(1) // liveData 가 아니더라도 뷰에 바인딩 가능한가 ?
    val totalCardCnt: LiveData<Int>
        get() = _totalCardCnt

    // 카드나 list => CardMeFragement 에서 사용
    private val _cardMeList = MutableLiveData<MutableList<ResponseCardMeData.CardList.CardMe>>()
    val cardMeList: LiveData<MutableList<ResponseCardMeData.CardList.CardMe>>
        get() = _cardMeList


    fun setUserId(id: Int?) {
        _id = id
    } // 타인의 프래그먼트 생성시, 그 프래그먼트 코드 단에서 getArguments로 받아온 newId를 setUserId(newId) 이런형식으로 설정 ?

    fun setUserName(name: String?) {
        _name = name
    }

    fun setTotalCardCnt() {
        viewModelScope.launch {
            // 수정 필요
//            try {
//                _totalCardCnt = ApiService.cardService.getCardAll().data.totalCardCnt
//            } catch (e: Exception) {
//                Log.d("2LogIn test Log",e.toString())
//            }
        }
    }

    fun updateCardMeList() {
        if (_id == null) { // 본인의 카드나 접근
            viewModelScope.launch {
                runCatching {
                    cardRepository.getCardMe().data
                }.onSuccess {
                    it.apply {
                        _cardMeList?.value = it.cardMeList
                    }
                }.onFailure {
                    Timber.e(it.toString())
                }
            }
        } else { // 타인의 카드나 접근
            viewModelScope.launch {
                runCatching {
                    cardRepository.getOtherCardMe(_id!!).data
                }.onSuccess {
                    it.apply {
                        _cardMeList?.value= it.cardMeList
                    }
                }.onFailure {
                    Timber.e(it.toString())
                }
            }
        }
    }
}