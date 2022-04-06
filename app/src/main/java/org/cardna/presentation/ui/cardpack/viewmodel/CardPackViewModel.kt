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

    private var _id: Int? = null  //뷰모델 객체가 각자 생성된다면 id없이 넘어올때 따로 null로 세팅안해줘도됨
    val id: Int? get() = _id

    private var _name: String? = null
    val name: String?
        get() = _name

    private val _totalCardCnt = MutableLiveData<Int>(1) // liveData 가 아니더라도 뷰에 바인딩 가능한가 ?
    val totalCardCnt: LiveData<Int>
        get() = _totalCardCnt

    private val _cardMeList = MutableLiveData<MutableList<ResponseCardMeData.CardList.CardMe>>()
    val cardMeList: LiveData<MutableList<ResponseCardMeData.CardList.CardMe>>
        get() = _cardMeList


    fun setUserId(id: Int?) {
        Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ",id.toString() ?: "널인딩")
        _id = id
    }

    fun setUserName(name: String?) {
        _name = name
    }

    /* fun setTotalCardCnt() {
         viewModelScope.launch {
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
         }
     }*/

    fun updateCardMeList() {
        Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ",_id.toString() ?: "널인딩")
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
                        _cardMeList?.value = it.cardMeList
                    }
                }.onFailure {
                    Timber.e(it.toString())
                }
            }
        }
    }

    override fun onCleared() {
        Log.d("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ","뷰모델 죽어용")
        //1. 내가 내 카드팩볼떄 생성된 뷰모델객체라면 메인액티비티 즉 앱이 꺼질때 뷰모델 파괴됨
        //2. 친구 액티비티 만들어질때 생성된 뷰모델객체라면 친구 액티비티 finish될 때 뷰모델 파괴됨
        super.onCleared()
    }
}